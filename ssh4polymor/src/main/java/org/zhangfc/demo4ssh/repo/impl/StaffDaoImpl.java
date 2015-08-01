package org.zhangfc.demo4ssh.repo.impl;

import org.springframework.stereotype.Repository;
import org.zhangfc.demo4ssh.domain.Staff;
import org.zhangfc.demo4ssh.repo.PersonDao;

@Repository("staffDao")
public class StaffDaoImpl extends GenericDaoImpl<Staff, Integer> 
	implements PersonDao<Staff> {
	
}
