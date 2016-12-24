package cn.pluto.www.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String username;
	private String password;
	
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
	
	@Override
	public String execute() throws Exception{
		if ("tom".equals(this.getUsername().trim()) && "123".equals(this.getPassword().trim()))
			return "success";
		else
			return "fail";
	}
	
	public String login(){
		if (username != null && username.equals(password))
			return "success";
		else
			return "fail";
	}
	
	public String register(){
		if (username != null && username.equals(password))
			return "success";
		else
			return "fail";
	}
	
}
