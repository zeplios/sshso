package org.zhangfc.demo4ssh.repo;

import org.zhangfc.demo4ssh.domain.Person;

public interface PersonDao<T extends Person> extends GenericDao<T, Integer> {

}
