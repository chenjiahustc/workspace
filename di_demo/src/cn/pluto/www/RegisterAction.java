package cn.pluto.www;

public class RegisterAction {
	private UserBean userBean = null;
	
	public UserBean getUserBean() {
		return userBean;
	}


	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String register(String username, String password){
		userBean.setUserName(username);
		userBean.setUserPass(password);
		
		if (userBean.registerUser())
			return "success";
		else
			return "fail";
	}
}
