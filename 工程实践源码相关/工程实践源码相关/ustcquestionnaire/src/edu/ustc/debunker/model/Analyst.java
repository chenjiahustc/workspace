package edu.ustc.debunker.model;

import java.io.Serializable;

public class Analyst implements Serializable{

	
	private String name;
	private String mail;
	private String phone;
	private String work_place;
	private String account;
	private String password;
	public Analyst(String account2, String passWord2) {
		this.account = account2;
		this.password = passWord2;
		// TODO Auto-generated constructor stub
	}
	public Analyst() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWork_place() {
		return work_place;
	}
	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
