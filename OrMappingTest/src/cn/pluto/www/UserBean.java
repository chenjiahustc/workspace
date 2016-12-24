package cn.pluto.www;

import java.sql.ResultSet;

public class UserBean {
	private String username = null;
	private String password = null;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean checkLogin(){
		UserDAO userdao = new UserDAO();
		UserBean ub = null;
		
		ub = userdao.queryUser(username);
		
		if (ub != null){
			if (ub.getPassword().equals(password))
				return true;
			else
				return false;
		}else
			return false;
	}
	
	public boolean registerUser(){
		UserDAO userdao = new UserDAO();
		
		return userdao.insertUser(this);
	}
	
	public boolean updateUser(){
		UserDAO userdao = new UserDAO();
		
		return userdao.updateUser(this);
	}
	
	public boolean deleteUser(){
		UserDAO userdao = new UserDAO();
		
		return userdao.deleteUser(this);
	}
}
