package edu.ustc.debunker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.ustc.debunker.model.Answers;

public class AnswersDao {
	//answer表的增删改查
	public void setAnswer(Answers answers){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(answers);
		transaction.commit();
		session.close();
	}
	public void setAnswers(List<Answers> answers){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		for(Answers answer : answers){
			session.save(answer);
		}		
		transaction.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Answers> getAnswerByExamID(String exam_id){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Answers where exam_id = ?");
		query.setString(0,exam_id);
		List<Answers> answers = query.list();
		transaction.commit();
		session.close();
		return answers;
		
	}
	public List<String> getworknumByExamID(String exam_id){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select distinct work_number from Answers where exam_id = ?");
		query.setString(0,exam_id);
		List<String> worknum = query.list();
		transaction.commit();
		session.close();
		return worknum;

	}
	public String getPaperIDByExamID(String exam_id){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select distinct paper_id from Answers where exam_id = ?");
		query.setString(0,exam_id);
		List<String> paper_idList = query.list();
		String paper_id = paper_idList.get(0);
		transaction.commit();
		session.close();
		return paper_id;

	}
	public void updataAnswer(Answers answers){
		
	}
	public void deleteAnswer(Answers answers){
		
	}
	
}
