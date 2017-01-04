package cn.zq.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.zq.www.dao.UserDAO;
import cn.zq.www.dao.impl.UserDAOImpl;
import cn.zq.www.entity.User;

public class UserUpdateAction extends ActionSupport{
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

	public String userUpdateInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user  = (User)session.getAttribute("user");
		UserDAO userdao = new UserDAOImpl();
		this.user = userdao.findUserById(user.getUserid());

		return "userUpdate";
	}

	public String updateUser(){
		UserDAO userdao = new UserDAOImpl();
		userdao.updateUser(user);
		message = "修改信息成功";

		return "updateSuc";
	}
}
