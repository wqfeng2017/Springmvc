package com.tz.spring.dao.impl;

import java.util.logging.LogManager;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.tz.spring.dao.ILogDao;
import com.tz.spring.entity.LogMessage;

@Repository("logDao")
public class LogDaoImpl implements ILogDao {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void insert(LogMessage log) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		/*Session ses = null;
		
		try {
			ses = sessionFactory.openSession();
			ses.getTransaction().begin();
			ses.saveOrUpdate(log);
			//throw new HibernateException();
			ses.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			ses.close();
		}*/
		
		sessionFactory.getCurrentSession().saveOrUpdate(log);
	}

	

}
