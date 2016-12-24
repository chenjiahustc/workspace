package edu.ustc.debunker.model;

import java.io.Serializable;
import java.util.*;

public class Answers implements Serializable{
	  /* answer_id			int not null,		答题编号
	   work_number          varchar(20),		工号
	   paper_id             varchar(10),		问卷号
	   answer_time          date,				答题时间
	   answer               varchar(100),		答案
	   question_id          int ,				问题编号
	   exam_id              int	,				考试编号*/
	private int answer_id;
	private String work_number;
	private String paper_id;
	private Date answer_time;
	private String answer;
	private int question_id;
	private String exam_id;
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public String getWork_number() {
		return work_number;
	}
	public void setWork_number(String work_number) {
		this.work_number = work_number;
	}
	public String getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}
	public Date getAnswer_time() {
		return answer_time;
	}
	public void setAnswer_time(Date answer_time) {
		this.answer_time = answer_time;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	
}
