package cn.pluto.www;

import cn.pluto.www.dao.Conversation;

public class ORMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBean ub = new UserBean();
		
		ub.setUsername("cj");
		ub.setPassword("123");
		System.out.println(Conversation.saveUser(ub));
		
		ub = Conversation.getUser("username", "cj");
		System.out.println(ub.getUserid());
		System.out.println(ub.getUsername());
		System.out.println(ub.getPassword());
		
		ub.setPassword("1234");
		System.out.println(Conversation.updateUser(ub));
		System.out.println(ub.getUserid());
		System.out.println(ub.getUsername());
		System.out.println(ub.getPassword());
		
		System.out.println(Conversation.deleteUser(ub));
	}

}
