package edu.ustc.debunker.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.ustc.debunker.dao.AnalystDao;
import edu.ustc.debunker.model.Analyst;
import edu.ustc.debunker.service.LoginService;

public class LoginAction extends ActionSupport {

	private String account;
	private String passWord;
	private String userName; 
	private Analyst user;
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setauthority(String authority){
		ServletActionContext.getRequest().getSession().setAttribute("authority",authority);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String execute() {
		// TODO Auto-generated method stub
		Analyst user = new Analyst(this.account,this.passWord);
		LoginService  ls = new LoginService();
		AnalystDao ad = new AnalystDao();
		Analyst dban = ad.getAnalystByAccount(this.account);
		String value = "test";
		if(ls.loginCheck(user)){
			setUser(dban);
			ActionContext context=ActionContext.getContext();
			//往request里放attribute
			context.put("value",value);
			if("admins".equals(user.getAccount())){
				setauthority("high");
				return SUCCESS;
			}
			else{
				setauthority("low");
				return SUCCESS;
			}
		}
		else{
			return ERROR;
		}
		
	}
	public Analyst getUser() {
		return user;
	}
	public void setUser(Analyst user) {
		this.user = user;
	}
}
