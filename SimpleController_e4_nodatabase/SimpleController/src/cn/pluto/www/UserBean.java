package cn.pluto.www;

import java.sql.ResultSet;

public class UserBean {
	public boolean checkLogin(User user){
		if (user.getUsername().equals(user.getPassword()))
			return true;
		else
			return false;
	}
	
	public boolean registerUser(User user){
		if (user.getUsername().equals(user.getPassword()))
			return true;
		else
			return false;
	}
}
