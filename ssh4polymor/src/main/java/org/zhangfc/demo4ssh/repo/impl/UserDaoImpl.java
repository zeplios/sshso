package org.zhangfc.demo4ssh.repo.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zhangfc.demo4ssh.domain.User;
import org.zhangfc.demo4ssh.repo.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public int save(User u) {
		return (Integer) sessionFactory.getCurrentSession().save(u);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

}
