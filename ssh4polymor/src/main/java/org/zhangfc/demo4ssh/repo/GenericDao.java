package org.zhangfc.demo4ssh.repo;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	
	T findById(ID id);

	ID save(T entity);

	void update(T entity);

	void delete(T entity);

	void evict(T entity);

	void flush();
	
	List<T> findAll();

}
