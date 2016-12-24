package edu.ustc.debunker.model;

import java.io.Serializable;
import java.util.Date;

public class Paper implements Serializable{
	/* paper_id             varchar(10) not null,
	   account              varchar(100),
	   is_public            bool,
	   creation_time        date,*/
	private String paper_id;
	private String account;
	private boolean is_public;
	private Date creation_time;
	public String getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public boolean isIs_public() {
		return is_public;
	}
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}
	public Date getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	
}
