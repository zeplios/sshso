package org.zhangfc.demo4ssh.aspect;

import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Aspect
public class PersonServiceAspect {

	@Autowired
	private WebApplicationContext wac;
	//private WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
	
	@Before("execution(* org.zhangfc.demo4ssh.service.PersonServiceImpl.*(..))")
	public void wirePersonDao(JoinPoint joinPoint) {
		Object [] args = joinPoint.getArgs();
		Object service = joinPoint.getTarget();
		Field dao = null;
		try {
			dao = service.getClass().getDeclaredField("personDao");
			if (!dao.isAccessible()) {
				dao.setAccessible(true);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			return;
		}
		if (args.length == 0 || args[0].equals(0)) {
			setBean(dao, service, "personDao");
		}
		if (args.length > 1 && args[0].equals(1)) {
			setBean(dao, service, "employerDao");
		}
		if (args.length > 1 && args[0].equals(2)) {
			setBean(dao, service, "staffDao");
		}
	}
	
	public boolean setBean(Field dao, Object service, String beanName){
		try {
			dao.set(service, wac.getBean(beanName));
			return true;
		} catch (BeansException | IllegalArgumentException
				| IllegalAccessException e) {
			return false;
		}
	}

}
