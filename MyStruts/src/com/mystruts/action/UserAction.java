package com.mystruts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.mystruts.service.UserService;
import com.mystruts.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
			return SUCCESS;
		
	}
	public String login() throws Exception {
		User userLogin = userService.loginUser(user);
		if (userLogin != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", userLogin);
			return SUCCESS;
		}
		return INPUT;
	}
	
}
