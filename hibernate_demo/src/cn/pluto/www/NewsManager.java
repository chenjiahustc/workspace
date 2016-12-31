package cn.pluto.www;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NewsManager {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		
		News n = new News();
		n.setTitle("Java title");
		n.setContent("Java content");
		
		sess.save(n);
		
		tx.commit();
		
		sess.close();
		sf.close();
	}

}
