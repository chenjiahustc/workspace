package cn.pluto.www;

import java.sql.ResultSet;

import cn.pluto.www.dao.Conversation;

public class UserBean {
	private int userid;
	private String username = null;
	private String password = null;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

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
		UserBean ub = null;
		
		ub = Conversation.getUser("username", username);
		
		if (ub != null){
			if (ub.getPassword().equals(password))
				return true;
			else
				return false;
		}else
			return false;
	}
	
	public boolean registerUser(){	
		return Conversation.saveUser(this);
	}
	
	public boolean updateUser(){
		return Conversation.updateUser(this);
	}
	
	public boolean deleteUser(){
		return Conversation.deleteUser(this);
	}
}
