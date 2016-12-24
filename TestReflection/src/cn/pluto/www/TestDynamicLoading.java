package cn.pluto.www;

import java.lang.reflect.Method;

public class TestDynamicLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String classname = "cn.pluto.www.LoginAction";
		String method = "login";
		
		Class cl = null;
		Object ob = null;
		Method m = null;
		
		try{
			cl = Class.forName(classname);
			ob = cl.newInstance();
			m = cl.getMethod(method, new Class[]{String.class, String.class});
		} catch(Exception e){
			e.printStackTrace();
		}
		
		String result = null;
		try{
			result = (String)m.invoke(ob, new String[]{"test", "test"});
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(result);
	}

}

class A{
	
}

class B{
	
}

class C{
	
}

class D{
	
}