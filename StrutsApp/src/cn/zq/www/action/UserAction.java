package cn.zq.www.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.zq.www.dao.UserDAO;
import cn.zq.www.dao.impl.UserDAOImpl;
import cn.zq.www.entity.User;

public class UserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public String login(){
		UserDAO userdao = new UserDAOImpl();
		User userLogin = userdao.loginUser(user);
		if (userLogin != null){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", userLogin);
			
			return SUCCESS;
		}
		
		return INPUT;
	}
	
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return INPUT;		
	}
	
	public String register(){
		//todo save user to db
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDAO userdao = new UserDAOImpl();
		userdao.saveUser(user);
		System.out.println(user.getUserid());
		session.setAttribute("user", this.user);
		
		return SUCCESS;
	}
	
	public String listUser(){
		Map request = (Map) ActionContext.getContext().get("request");
		UserDAO userdao = new UserDAOImpl();
		List<User> userList = userdao.findAllUsers();
		request.put("list", userList);
		
		return "listSuc";
	}
	
}
