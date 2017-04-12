package com.tz.spring.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadSpringContex implements ServletContextListener {
	ServletContext sc ;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		sc = event.getServletContext();
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		sc.setAttribute("ac", ac);
	}

}
