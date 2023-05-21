package com.profinch.springmvcboot.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
//	@Before("execution(public * com.profinch.springmvcboot.controller.*.*(..))")
//	public void logBefore(JoinPoint joinPoint) {
//		
//		Signature signature = joinPoint.getSignature();
//		LOGGER.info(signature.getName() + " method is called from aspect.");
//	}
	
	@Around("execution(public * com.profinch.springmvcboot.controller.*.*(..))")
	public Object logBefore(ProceedingJoinPoint jp) {
		
		Object obj = null;
		Signature signature = jp.getSignature();
		try {
			LOGGER.info(signature.getName() + " method is called before around.");

			obj = jp.proceed();
			
			LOGGER.info(signature.getName() + " method is called after around.");

			
		} catch(Throwable e) {
			
			LOGGER.error("An error occurred: ", e.getMessage());
		}
		
		return obj;
	}
}
