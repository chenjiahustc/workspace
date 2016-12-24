package edu.ustc.debunker.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.ustc.debunker.dao.AnswersDao;
import edu.ustc.debunker.dao.PaperDao;
import edu.ustc.debunker.dao.QuestionsDao;
import edu.ustc.debunker.model.Analyst;
import edu.ustc.debunker.model.Answers;
import edu.ustc.debunker.model.Paper;
import edu.ustc.debunker.model.Questions;


public class SystemTest {
	/*
	public static void main(String[] args) throws IOException{
		
		AnswersDao ad = new AnswersDao();
		QuestionsDao qd = new QuestionsDao();
		PaperDao pd = new PaperDao();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		List<Answers> aall = ad.getAnswerByExamID("2");
		List<Questions> qall = qd.getAnswerByPaperID("6");
		List<String> wall = ad.getworknumByExamID("1");
		List<Integer> pall = pd.getPaperIDByAccount("Jack");
		String paper_id = ad.getPaperIDByExamID("2");
		System.out.println(paper_id);
		for(Integer a:pall){
			System.out.println(a);
		}
		//System.out.println(wall.size());
		for(String a:wall){
			System.out.println(a);
		}
		int i = 0;
		for(Answers a:aall){
			Questions q = qall.get(i++);
			System.out.println(q.getQuestion()+"  -->    "+a.getAnswer());
		}
		PaperToExlService pte = new PaperToExlService();
		System.out.println(out.size());
		pte.PaperToExl(qall, aall, "2", "Jack", out);
	}
	/*public static void main(String[] args) throws IOException{
		Answers answers = new Answers();
		String paper_id = "1";
		int question_id = 1;
		Date answer_time = new Date();
		java.sql.Date sqlDate=new java.sql.Date(answer_time.getTime());
		answers.setAnswer("韦思聪");
		answers.setAnswer_time(sqlDate);
		answers.setExam_id("3");
		answers.setPaper_id(paper_id);
		answers.setQuestion_id(1);
		AnswersDao ad = new AnswersDao();
		ad.setAnswer(answers);
	}*/
	
}
