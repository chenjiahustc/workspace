package cn.pluto.www;

import cn.pluto.www.dao.Conversation;

public class ORMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBean ub = null;
		
		ub = Conversation.getUser("username", "test");
		
		System.out.println(ub.getUsername());
		System.out.println(ub.getPassword());

	}

}
