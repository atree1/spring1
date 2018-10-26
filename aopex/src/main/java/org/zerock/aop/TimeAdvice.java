package org.zerock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
@Order(value= Ordered.HIGHEST_PRECEDENCE)
public class TimeAdvice {

	
	@Around("execution(* org.zerock.service.*.*(..))")
	public Object checkTime(ProceedingJoinPoint pjp) {
		
		Object result = null;
		
		
		try {
			long start = System.currentTimeMillis();
			
			result = pjp.proceed();
		
			long end = System.currentTimeMillis();
			log.info("TOTAL: " + (end - start));
			
			return result;
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}


