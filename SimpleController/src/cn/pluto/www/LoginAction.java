package cn.pluto.www;

public class LoginAction implements LoginActionInterface{
	public String login(String username, String password){
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		
		if (user.checkLogin())
			return "success";
		else
			return "fail";
	}
}
