package cn.zq.www.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
		User userLogin = user;
		userLogin.setMobile("18100676860");
		userLogin.setEmail("970583834@qq.com");
		System.out.println(user.getUsername() + " : " + user.getPassword());
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
		session.setAttribute("user", this.user);
		
		return SUCCESS;
	}
	
	public String listUser(){
		Map request = (Map) ActionContext.getContext().get("request");
		List<User> userList = new ArrayList<User>();
		User userDefault = new User();
		userDefault.setUsername("pluto");
		userDefault.setPassword("123");
		userDefault.setMobile("01111314520");
		userDefault.setEmail("tomcat@ustc.edu.cn");
		userList.add(userDefault);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		userList.add((User)session.getAttribute("user"));
		
		request.put("list", userList);
		
		return "listSuc";
	}
	
}
