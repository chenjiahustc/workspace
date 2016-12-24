package cn.pluto.www;

public class Sqlite3Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		
		user.setUsername("abc");
		user.setPassword("abc");
		
		System.out.println(user.checkLogin());
		user.setUsername("fff");
		user.setPassword("fff");
		System.out.println(user.registerUser());
	}

}
