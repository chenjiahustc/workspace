package com.mystruts.service;

import com.mystruts.entity.User;
import java.util.List;
import com.mystruts.dao.UserDAO;
import com.mystruts.service.UserService;

public class UserServiceImpl  implements UserService{
	private UserDAO userDao;
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public void save(User user) {
		this.userDao.saveUser(user); 
	}
	public List<User> findAll() {
		return this.userDao.findAllUsers();
	}
	public void delete(User user) {
		this.userDao.removeUser(user);
	}
	public void update(User user) {
		this.userDao.updateUser(user);
	}
	public User findById(Integer id) {
		return this.userDao.findUserById(id);
	}
	public User loginUser(User user) {
		return this.userDao.loginUser(user);
	}
	
	

}
