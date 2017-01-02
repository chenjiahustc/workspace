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
	* @return 获取会话工厂
	*/
	public static SessionFactory getSessionFactory()
	{
		configuration = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
       
	/**
	* @return 获取会话对象
	*/
	public static Session getSession()
	{
		return getSessionFactory().openSession();
	}
}