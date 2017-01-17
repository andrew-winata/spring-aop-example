package com.blibli.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Before("execution ( * com.blibli.Bird.eat(..))")
	public void catchBeforeMethodExecution(JoinPoint joinPoint){
		System.out.println("EXECUTED BEFORE");
		System.out.println("Method name "+joinPoint
				.getSignature().getName());
		System.out.println("***************");
	}
	
	@Before("execution ( public * *(..))")
	public void catchAllPublicMethodBeforeExecution(JoinPoint joinPoint){
		System.out.println("CATCH ALL METHOD BEFORE EXECUTED");
		System.out.println("Method name "+joinPoint
				.getSignature().getName());
		System.out.println("***************");
	}
	
	@After("execution ( * com.blibli.Bird.eat(..))")
	public void catchAfterMethodExecuted(JoinPoint joinPoint){
		System.out.println("CATCH ALL METHOD AFTER EXECUTED");
		System.out.println("Method name "+joinPoint
				.getSignature().getName());
		System.out.println("***************");
	}
	
	@AfterReturning(pointcut = "execution ( * com.blibli.Bird.eatSomething(..))", returning ="result")
	public void catchAfterReturningMethodExecuted(JoinPoint joinPoint, Object result){
		System.out.println("CATCH ALL METHOD AFTER EXECUTED");
		System.out.println("Arguments : "+Arrays.toString(joinPoint
				.getArgs()));
		System.out.println("Returned : "+ result);
		System.out.println("***************");
	}
	
	@Around("execution ( * com.blibli.Bird.eat(..))")
	public void catchAfterReturnedMethodExecuted(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("AROUND BEFORE EXECUTED");
		System.out.println("Method name "+joinPoint
				.getSignature().getName());
		joinPoint.proceed();
		System.out.println("AROUND AFTER EXECUTED");
		System.out.println("***************");
	}
	
	
	
}
