package org.zerock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;


@Aspect
@Log4j
public class NullAdvice {

	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object checkNull(ProceedingJoinPoint pjp) {
		
		log.info("checkNull.................................");
		log.info("checkNull.................................");
		log.info("checkNull.................................");
		Object result=null;
		try {
			boolean checkNull=false;
			Object[] params=pjp.getArgs();
			for (Object object : params) {
				if(object==null)
					throw new Exception("Null");
			}
			result=pjp.proceed(); //method 실행 invoke
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
