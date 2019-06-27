package com.holylala.springbootstu.aspect;

import com.holylala.springbootstu.aspect.validator.UserValidator;
import com.holylala.springbootstu.aspect.validator.impl.UserValidatorImpl;
import com.holylala.springbootstu.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

//@Aspect 定义切面  @Order(1) 定义哪个切面的方法先执行
@Aspect
@Order(1)
public class MyAspect {


	// @DeclareParents 引入新的类来增强服务 value: 指向需要增强功能的目标对象 defaultImpl: 引入增强功能的类
	@DeclareParents(value= "com.holylala.springbootstu.aspect.service.impl.UserServiceImpl", defaultImpl=UserValidatorImpl.class)
	public UserValidator userValidator;



	@Before("pointCut() && args(user)")
	public void beforeParam(JoinPoint point, User user) {
		System.out.println("beforeParam ......");

		Object[] argArray = point.getArgs();
		for (Object o : argArray) {
			System.out.println("args:>>>");
			User user1 = (User)o;
			System.out.println("argArray get UserName:>>>" + user1.getUserName());
		}

		System.out.println("param User get UserName:>>>" + user.getUserName());
	}

	//定义一个切点
	@Pointcut("execution(* com.holylala.springbootstu.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void pointCut() {
	}

	//直接引用这个切点
//	@Before("pointCut()")
//	public void before() {
//		System.out.println("myaspect before ......");
//	}
	
	@After("execution(* com.holylala.springbootstu.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void after() {
		System.out.println("myaspect after ......");
	}
	
	
	@AfterReturning("execution(* com.holylala.springbootstu.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void afterReturning() {
		System.out.println("myaspect afterReturning ......");
	}
	
	@AfterThrowing("execution(* com.holylala.springbootstu.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void afterThrowing() {
		System.out.println("myaspect afterThrowing ......");
	}
	

	//环绕通知 尽量避免使用 因为和 @Before 会有执行顺序的差异(不同Spring版本)
	@Around("pointCut()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("myaspect around before......方法签名:>>>" + jp.getSignature().getName() + ",方法返回的对象args0:>>>" + jp.getArgs()[0]);



		Object[] argArray = jp.getArgs();
		for (Object o : argArray) {
			System.out.println("args:>>>" + o);
		}

		jp.proceed();

		System.out.println("myaspect around after......");
	}
}
