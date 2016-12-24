package edu.ustc.debunker.model;

import java.io.Serializable;

public class Participant implements Serializable{
	/*name                 varchar(30) not null,
	   sex                  varchar(4),
	   phone                varchar(15) not null,
	   mail                 varchar(50),
	   work_place           varchar(100),
	   work_number          varchar(20) not null,
	   account              varchar(100),
	   primary key (work_number)*/
	private String name;
	private String sex;
	private String phone;
	private String mail;
	private String work_place;
	private String work_number;
	private String account;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getWork_place() {
		return work_place;
	}
	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}
	public String getWork_number() {
		return work_number;
	}
	public void setWork_number(String work_number) {
		this.work_number = work_number;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
