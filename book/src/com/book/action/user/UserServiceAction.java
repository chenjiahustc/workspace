package com.book.action.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.book.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserServiceAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception{
		return super.execute();
	}
	
	public String listUser(){
		Map request = (Map)ActionContext.getContext().get("request");
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setUserid(3);
		user.setUsername("test");
		user.setPassword("test");
		user.setMobile("18100676860");
		user.setEmail("970583834@qq.com");
		userList.add(user);
		request.put("list", userList);
		
		return SUCCESS;
	}
	
	public String saveUser(){
		return "saveSuc";
	}
	
	public String removeUser(){
		return SUCCESS;
	}
	
	public String userUpdateInfo() {
		try{

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			this.user = user;
			return "userUpdate";
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return "userUpdate";
		
	}
	public String updateUser(){
		return "updateSuc";
	}
	
	public String login(){
		if (user.getUsername().equals(user.getPassword())){
			try{
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				user.setMobile("18100676860");
				user.setEmail("970583834@qq.com");
				session.setAttribute("user", user);
			
				return "loginSuc";
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return INPUT;
	}
	
	public String logout(){
		return "logoutSuc";
	}
}
