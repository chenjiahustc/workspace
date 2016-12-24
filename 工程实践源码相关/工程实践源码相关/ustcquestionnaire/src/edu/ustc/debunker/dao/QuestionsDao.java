package edu.ustc.debunker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.ustc.debunker.model.Paper;
import edu.ustc.debunker.model.Questions;

public class QuestionsDao {
	public List<Questions> getAnswerByPaperID(String paper_id){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Questions where paper_id = ?");
		query.setString(0,paper_id);
		List<Questions> questions = query.list();
		transaction.commit();
		session.close();
		return questions;
		
	}
}
