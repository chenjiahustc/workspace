package cn.pluto.www;

public class RegisterAction {
	public String register(String username, String password){
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		

		if (user.registerUser())
			return "success";
		else
			return "fail";
	}
}
