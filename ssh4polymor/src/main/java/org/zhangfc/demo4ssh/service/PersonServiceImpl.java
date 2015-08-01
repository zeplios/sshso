package org.zhangfc.demo4ssh.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.zhangfc.demo4ssh.domain.Person;
import org.zhangfc.demo4ssh.repo.PersonDao;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	private PersonDao<Person> personDao;

	public Person findById(int type, int id) {
		return personDao.findById(id);
	}

}
