package cn.pluto.www;

public class LoginAction implements LoginActionInterface{
	public String login(String username, String password){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserBean ub = new UserBean();
		
		if (ub.checkLogin(user))
			return "success";
		else
			return "fail";
	}
}
