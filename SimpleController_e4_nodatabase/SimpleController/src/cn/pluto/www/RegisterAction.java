package cn.pluto.www;

public class RegisterAction {
	public String register(String username, String password){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserBean ub = new UserBean();
		if (ub.registerUser(user))
			return "success";
		else
			return "fail";
	}
}
