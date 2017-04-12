package com.tz.spring.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tz.spring.entity.User;
import com.tz.spring.service.IUserService;

public class TestSpring {
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	//IUserService us;
	//ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	@Test
	public void testSave(){
		IUserService us = (IUserService) ac.getBean("userService");  //new UserServiceImpl();
		//IUserService us2 = (IUserService) ac.getBean("userService");  //new UserServiceImpl();
		
		//System.out.println(us1 == us2);
		
		//us = ac.getBean("userService",UserServiceImpl.class);
		//us.queryUserById(10L);
		
		us.save(new User("lucy","123456",new Date()));
		
		//User user = us.queryUserById(29L);
		
		//System.out.println(user);
		
		//ac.close();
	}
}
