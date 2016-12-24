package com.book.action.admin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.book.entity.Admin;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminServiceAction extends ActionSupport {
	private Admin admin;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public String execute() throws Exception{
		return super.execute();
	}
	
	public String login(){
		if (admin.getUsername().equals(admin.getPassword())){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			return "loginSuc";
		}
		
		return INPUT;
	}
	
	public String loginOut() throws Exception{
		return INPUT;
	}
}
