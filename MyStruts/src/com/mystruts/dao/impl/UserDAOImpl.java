package com.mystruts.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mystruts.dao.UserDAO;
import com.mystruts.entity.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
	}
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		String hql = "from User user order by user.userid desc";
		return (List<User>) this.getHibernateTemplate().find(hql);
	}
	public void removeUser(User user) {
		this.getHibernateTemplate().delete(user);
	}
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}
	public User findUserById(Integer id) {
		User user = (User) this.getHibernateTemplate().get(User.class, id);

		return user;
	}                      
	@SuppressWarnings("unchecked")
	public User loginUser(User user) {
		String hql = "from User users where users.username='"
				+ user.getUsername() + "' and users.password='"
				+ user.getPassword() + "'";
		List<User> users = (List<User>) this.getHibernateTemplate().find(hql);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}