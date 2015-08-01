package org.zhangfc.demo4ssh.repo.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zhangfc.demo4ssh.repo.GenericDao;

@SuppressWarnings("unchecked")
public class GenericDaoImpl<T, ID extends Serializable> implements
		GenericDao<T, ID> {

	protected Class<T> persistentClass;

	@Autowired
	protected SessionFactory sessionFactory;

	public GenericDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T findById(ID id) {
		return (T) getCurrentSession().get(persistentClass, id);
	}

	@Override
	public ID save(T entity) {
		return (ID) getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	@Override
	public void evict(T entity) {
		getCurrentSession().evict(entity);
	}

	@Override
	public void flush() {
		getCurrentSession().flush();
	}

	@Override
	public List<T> findAll() {
		Criteria criteria = getCurrentSession().createCriteria(persistentClass);
		return criteria.list();
	}

}
