package cn.pluto.www;

import java.sql.ResultSet;

public class UserBean {
	private Integer userID;
	private String userName = null;
	private String userPass = null;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public boolean checkLogin(){
		if (userName != null && userPass != null && userName.equals(userPass))
			return true;
		else
			return false;
	}
	
	public boolean registerUser(){
		if (userName != null && userPass != null && userName.equals(userPass))
			return true;
		else
			return false;
	}
}
