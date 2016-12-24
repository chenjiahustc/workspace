package edu.ustc.debunker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.ustc.debunker.model.Analyst;

public class AnalystDao {
	//Analyst表的增删改查
	public void setAnalyst(Analyst analyst){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(analyst);
		transaction.commit();
		session.close();
	}
	public Analyst getAnalystByAccount(String account){
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Analyst analyst = (Analyst)session.get(Analyst.class, account);
		transaction.commit();
		session.close();
		return analyst;
	}
	public void updateAnalyst(Analyst analyst){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(analyst);
		transaction.commit();
		session.close();
	}
	public void deleteAnalyst(Analyst analyst){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(analyst);
		transaction.commit();
		session.close();
		
	}
	
}
