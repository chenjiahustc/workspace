package com.huhang.model;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String password;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean validate(){
		if((("Tom".equals(name))&&("123".equals(password)))||("Huhang".equals(name)&&("123".equals(password))))
			return true;
		else
			return false;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
