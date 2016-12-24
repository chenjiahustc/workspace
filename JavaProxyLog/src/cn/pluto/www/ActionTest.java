package cn.pluto.www;

import java.lang.reflect.Proxy;

public class ActionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ÒÑ¾­¼ì²âÀ¹½ØÆ÷£¬Ö´ÐÐaction
		LoginActionInterface obj = new LoginAction();
		
		//ActionHandler handler = new ActionHandler(obj, "login", "cn.pluto.www.LogWriter", "log");
		ActionHandler handler = new ActionHandler(obj);
		
		LoginActionInterface proxy = (LoginActionInterface)Proxy.newProxyInstance(
				obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), 
				handler);
		System.out.println(proxy.login("cj", "123"));
	}

}
