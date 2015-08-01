package org.zhangfc.demo4ssh.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@AfterThrowing(value="within(org.zhangfc.demo4ssh.service..*)", throwing = "ex")
	public void loggingExceptions(JoinPoint joinPoint, Exception ex) {
		logger.error("Exception thrown in Method = "
				+ joinPoint.toString() + " " + ex.getClass().getSimpleName() + " = " + ex.getMessage());
	}

	@Pointcut("execution(* org.zhangfc.demo4ssh.repo..*.*(..))")
	public void daoPointCut() {
	}

	@Around("daoPointCut()")
	public Object loggingAround(ProceedingJoinPoint joinpoint) throws Throwable {
		long start = System.currentTimeMillis();
		logger.info("method starts...."
				+ joinpoint.getSignature().getDeclaringTypeName() + "_"
				+ joinpoint.getSignature().getName() + " with "
				+ arrayToString(joinpoint.getArgs()));
		Object result = joinpoint.proceed();
		long diff = System.currentTimeMillis() - start;
		logger.info("method ends...."
				+ joinpoint.getSignature().getDeclaringTypeName() + "_"
				+ joinpoint.getSignature().getName() + " with " + diff + "ms");
		return result;
	}

	private String arrayToString(Object[] traces) {
		StringBuilder trace = new StringBuilder();
		for (Object s : traces) {
			trace.append(s == null ? "" : s.toString() + "\t");
		}
		if (trace.length() == 0) {
			trace.append("no parameter");
		}
		return trace.toString();
	}

}
