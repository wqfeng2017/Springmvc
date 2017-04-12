package com.tz.spring.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.tz.spring.entity.User;


public class LogAdvice {
	
	//@Before("execution(* com.tz.spring.service.impl.UserServiceImpl.save(com.tz.spring.entity.User))")
	public void beforeLog(JoinPoint jp){
		
		System.out.println("用户保存成功----->"+new Date());
		String method = jp.getSignature().getName();
//		System.out.println(method);
		Object[] objs =jp.getArgs();
		User user = (User) objs[0];
//		System.out.println(user.getUsername());
		
	}
	
	//@Around("execution(* com.tz.spring.service.impl.UserServiceImpl.save(com.tz.spring.entity.User))")
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("方法执行之前.................");
		
		String method = pjp.getSignature().getName();
		
		Object[] objs = pjp.getArgs();
		
		User user = (User) objs[0];
		
		//System.out.println(user.getUsername()+"==============");
		
		pjp.proceed();
		
		System.out.println("方法执行之后................."+method);
	}
	
	//@AfterReturning("execution(* com.tz.spring.service.impl.*.*(..))")
	public void afterReturnAdvice(){
		System.out.println("方法成功执行之后.......");
	}
}
