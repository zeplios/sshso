package org.zhangfc.demo4ssh.service;

import org.zhangfc.demo4ssh.domain.Person;

public interface PersonService {

	Person findById(int type, int id);
	
}
