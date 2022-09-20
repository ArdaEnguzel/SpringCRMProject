package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forService() {}
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forController() {}
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDAO() {}
	@Pointcut("forController() || forDAO() || forService()")
	public void forAppFlow() {}
	@Before("forAppFlow()")
	public void login() {
		System.out.println("do something");
	}

}
