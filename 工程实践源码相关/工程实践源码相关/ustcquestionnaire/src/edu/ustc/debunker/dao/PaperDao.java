package edu.ustc.debunker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.ustc.debunker.model.Answers;
import edu.ustc.debunker.model.Paper;

public class PaperDao {

	public List<Integer> getPaperIDByAccount(String account){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select distinct paper_id from Paper where account = ?");
		query.setString(0,account);
		List<Integer> paperlist = query.list();
		transaction.commit();
		session.close();
		return paperlist;
	}
	
}
