package cn.zq.www;

import java.util.List;

import cn.zq.www.dao.impl.UserDAOImpl;
import cn.zq.www.entity.User;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAOImpl userdao = new UserDAOImpl();
		List<User> users = userdao.findAllUsers();
		
		for(User user : users){
			System.out.println("********************");
			System.out.println(user.getUserid());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println(user.getMobile());
			System.out.println(user.getEmail());
		}
		System.out.println("Ending......");
	}

}
