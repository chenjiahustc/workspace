package cn.pluto.www;

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
		return true;
	}
	
	public boolean registerUser(){
		return true;
	}
}
