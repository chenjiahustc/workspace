package cn.zq.www.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtil {
	private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;
      
	/**
	* @return ��ȡ�Ự����
	*/
	public static SessionFactory getSessionFactory()
	{
		configuration = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
       
	/**
	* @return ��ȡ�Ự����
	*/
	public static Session getSession()
	{
		return getSessionFactory().openSession();
	}
}