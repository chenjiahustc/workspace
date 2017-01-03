package cn.pluto.www;

public class LoginAction {
	private UserBean userBean = null;
	
	public UserBean getUserBean() {
		return userBean;
	}
	
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public String login(String username, String password){
		userBean.setUserName(username);
		userBean.setUserPass(password);
	
		if (userBean.checkLogin())
			return "success";
		else
			return "fail";
	}
}
