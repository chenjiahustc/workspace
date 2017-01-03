package cn.zq.www.dao;

import java.util.List;

import cn.zq.www.entity.User;

public interface UserDAO {
	public void saveUser(User user);
	public void batchsaveUser(List<User> users);
	public List<User> findAllUsers();
	public void removeUser(User user);
	public void updateUser(User user);
	public User findUserById(int id);
	public User loginUser(User user);
}
