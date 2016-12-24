package cn.pluto.www;

public class LoginAction implements LoginActionInterface {
	public String login(String username, String password){
		
		for(long i = 0;i < 10000000000L;i++)
			;
		return "success";
	}
}
