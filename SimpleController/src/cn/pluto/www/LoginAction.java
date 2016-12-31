package cn.pluto.www;

public class LoginAction {
	private UserBean userbean;
	public UserBean getUserbean() {
		return userbean;
	}
	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

	public String login(String username, String password){
		if (userbean.checkLogin())
			return "success";
		else
			return "fail";
	}
}
