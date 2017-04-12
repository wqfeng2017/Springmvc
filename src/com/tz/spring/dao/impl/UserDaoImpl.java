package com.tz.spring.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tz.spring.dao.IUserDao;
import com.tz.spring.entity.User;
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements IUserDao{
	//private DataSource myDataSource;
	private SessionFactory sessionFactory;
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		/*Session ses = null;
		try {
			ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.save(user);
			ses.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ses.close();
		}*/
		sessionFactory.getCurrentSession().save(user);
		
		//System.out.println("AAAAAAAAAAAAAAAAAAA");
	}

	@Override
	public User selectUserById(Long id) {
		// TODO Auto-generated method stub
		System.out.println("用戶查询成功!");
		
		return (User) this.sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		System.out.println("删除成功!");
	}

	@Override
	public void editor(User user) {
		// TODO Auto-generated method stub
		System.out.println("修改成功!");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User selectUserByName(String name) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.username="+name).uniqueResult();
	}

	@Override
	public List<User> selectUsers(String name) {
		// TODO Auto-generated method stub
		String hql = " FROM User u WHERE 1=1 ";
		if(name != null && !"".equals(name.trim())){
			hql += " and u.username like '%"+name+"%' ";
		}
		return this.sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	/*public 
	public DataSource getMyDataSource() {
		return myDataSource;
	}
	
	@Resource(name="myDataSource")
	public void setMyDataSource(DataSource myDataSource) {
		this.myDataSource = myDataSource;
	}*/
	
}
