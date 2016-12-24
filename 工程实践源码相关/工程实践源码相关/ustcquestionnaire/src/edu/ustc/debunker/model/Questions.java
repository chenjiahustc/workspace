package edu.ustc.debunker.model;

import java.io.Serializable;

public class Questions implements Serializable{
		/*paper_id             int,				问卷ID
	   question_id          int,				问题编号
	   question             varchar(200),		问题内容
	   weight               bool				是否算分*/
	private int paper_id;
	private int question_id;
	private String question;
	private boolean weight;
	public boolean isWeight() {
		return weight;
	}
	public void setWeight(boolean weight) {
		this.weight = weight;
	}
	public int getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	
}
