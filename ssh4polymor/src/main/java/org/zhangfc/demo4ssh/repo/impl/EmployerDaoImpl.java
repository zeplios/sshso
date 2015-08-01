package org.zhangfc.demo4ssh.repo.impl;

import org.springframework.stereotype.Repository;
import org.zhangfc.demo4ssh.domain.Employer;
import org.zhangfc.demo4ssh.repo.PersonDao;

@Repository("employerDao")
public class EmployerDaoImpl extends GenericDaoImpl<Employer, Integer> 
										implements PersonDao<Employer> {
	
}
