package cn.pluto.www;

import com.opensymphony.xwork2.ActionSupport;

public class HellowWorldAction extends ActionSupport {
	@Override
	public String execute() throws Exception{		
		return SUCCESS;
	}
	
	public String add(){
		return "add";
	}
	
	public String update(){
		return "update";
	}
}
