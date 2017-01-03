package cn.zq.www.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.zq.www.dao.HibernateUtil;
import cn.zq.www.dao.UserDAO;
import cn.zq.www.entity.User;

public class UserDAOImpl implements UserDAO{
	private Session session = null;
	private Transaction tran = null;
	private static String lockType = "Pessimistic"; // "Optimistic"

	@Override
	public void saveUser(User user) {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			session.save(user);
			tran.commit();
		} catch(Exception e){
			if (tran != null)
				tran.rollback();
		} finally{
			if (session != null)
				session.close();
		}

	}
	
	@Override
	public void batchsaveUser(List<User> users){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			int i = 0;
			for(User user : users){
				session.save(user);
				i++;
				if (i % 5 == 0){
					session.flush();
					session.clear();
				}
			}
			
			tran.commit();
		} catch(Exception e){
			if (tran != null)
				tran.rollback();
		} finally{
			if (session != null)
				session.close();
		}
	}
	
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		String hql = "from User as user";
		String sql = "select * from user";
		List<User> users = null;

		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			//users = session.createQuery(hql).list();
			//users = session.createCriteria(User.class).list();
			users = session.createSQLQuery(sql).addEntity(User.class).list();
			tran.commit();
		} catch(Exception e){
			;
		} finally{
			if (session != null)
				session.close();
		}

		return users;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			if (lockType.equals("Pessimistic")){
				session.lock(user, LockMode.UPGRADE);
			}else if (lockType.equals("Optimistic")){
				
			}else
				session.delete(user);
			
			tran.commit();
		} catch(Exception e){
			if (tran != null)
				tran.rollback();
		} finally{
			if (session != null)
				session.close();
		}
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			if (lockType.equals("Pessimistic")){
				session.lock(user, LockMode.UPGRADE);
				session.update(user);
			}else if (lockType.equals("Optimistic")){
				
			}else
				session.update(user);

			tran.commit();
		} catch(Exception e){
			if (tran != null)
				tran.rollback();
		} finally{
			if (session != null)
				session.close();
		}
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			user = (User)session.get(User.class, id);
		} catch(Exception e){
			;
		} finally{
			if (session != null)
				session.close();
		}

		return user;
	}

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		User loginUser = null;
		String hql = "from User as user where user.username= :name and user.password= :pwd" ;
		List<User> users = null;
		System.out.println(hql);
		try{
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			users = session.createQuery(hql).setString("name", user.getUsername()).setString("pwd", user.getPassword()).list();
			tran.commit();
			loginUser = users.get(0);
		} catch(Exception e){
			;
		} finally{
			if (session != null)
				session.close();
		}

		return loginUser;
	}

}
