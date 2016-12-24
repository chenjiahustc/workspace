package edu.ustc.debunker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.ustc.debunker.model.Analyst;
import edu.ustc.debunker.model.Participant;

public class ParticipantDao {
	public void setParticipant(Participant participant){
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(participant);
		transaction.commit();
		session.close();
	}
public Participant getParticipantByWorkNumber(String work_number){
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Participant participant = (Participant)session.get(Participant.class, work_number);
		transaction.commit();
		session.close();
		return participant;
	}
}
