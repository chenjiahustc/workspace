package cn.zq.www.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.zq.www.dao.UserDAO;
import cn.zq.www.dao.impl.UserDAOImpl;
import cn.zq.www.entity.User;

public class UserListAction extends ActionSupport{
	private User user;
	private String message;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception{
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
