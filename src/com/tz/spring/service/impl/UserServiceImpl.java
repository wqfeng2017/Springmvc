package com.tz.spring.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tz.spring.dao.ILogDao;
import com.tz.spring.dao.IUserDao;
import com.tz.spring.dao.impl.UserDaoImpl;
import com.tz.spring.entity.LogMessage;
import com.tz.spring.entity.User;
import com.tz.spring.service.IUserService;

//@Component("userService")
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	IUserDao userDao; //= new UserDaoImpl();
	ILogDao logDao;
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public void save(User user) {
		// TODO Auto-generated method stub
		this.userDao.insert(user);
		this.logDao.insert(new LogMessage(user.getUsername()+"插入到数据库:"+new Date()));
	}

	@Override
	@Transactional
	public User queryUserById(Long id) {
		// TODO Auto-generated method stub
		return this.userDao.selectUserById(id);
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	
	//@Autowired
	//@Qualifier("ud")
	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public ILogDao getLogDao() {
		return logDao;
	}
	@Resource(name="logDao")
	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}

	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub
		this.userDao.delete(user);
	}

	@Override
	public void modify(User user) {
		// TODO Auto-generated method stub
		this.userDao.editor(user);
	}

	@Override
	@Transactional
	public User queryUserByName(String name) {
		// TODO Auto-generated method stub
		return this.userDao.selectUserByName(name);
	}

	@Override
	@Transactional
	public List<User> queryUsers(String name) {
		// TODO Auto-generated method stub
		return this.userDao.selectUsers(name);
	}

}
