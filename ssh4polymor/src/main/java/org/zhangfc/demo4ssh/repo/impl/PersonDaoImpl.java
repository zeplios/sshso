package org.zhangfc.demo4ssh.repo.impl;

import org.springframework.stereotype.Repository;
import org.zhangfc.demo4ssh.domain.PersonUntyped;
import org.zhangfc.demo4ssh.repo.PersonDao;

@Repository("personDao")
public class PersonDaoImpl extends GenericDaoImpl<PersonUntyped, Integer> 
										implements PersonDao<PersonUntyped> {

}
