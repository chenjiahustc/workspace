package cn.pluto.www;

import cn.pluto.www.dao.Conversation;

public class UserBeanProxy extends UserBean {
	@Override
	public String getUsername() {
		String uname = null;
		uname = super.getUsername();
		if (uname == null){
			System.out.println("lazy-loading username property...");
			UserBean ub = Conversation.getUser(getUserid());
			this.setUsername(ub.getUsername());
		}
		
		return super.getUsername();
	}
	
	public String getPassword() {
		String upwd = null;
		upwd = super.getPassword();
		if (upwd == null){
			System.out.println("lazy-loading password property...");
			UserBean ub = Conversation.getUser(getUserid());
			this.setPassword(ub.getPassword());;
		}
		
		return super.getPassword();
	}
}
