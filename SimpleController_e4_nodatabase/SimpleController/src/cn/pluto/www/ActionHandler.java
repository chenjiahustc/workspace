package cn.pluto.www;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionHandler implements InvocationHandler {
	private Object targetObject;
	private String action;
	private Class cl = null;
	private Object ob = null;
	private Method m = null;
	
	public ActionHandler(Object targetObject, String action, String className, String classMethod){
		this.targetObject = targetObject;
		this.action = action;
		
		try{
			cl = Class.forName(className);
			ob = cl.newInstance();
			m = cl.getMethod(classMethod, new Class[]{String.class, String.class, boolean.class});
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public String getTime(){
		Date d = null;
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		
        d = new Date();  
        result = sdf.format(d);
        
        return result;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		String startTime = getTime();
		Object result = method.invoke(this.targetObject, args);
		String endTime = getTime();
		
		m.invoke(ob, new Object[]{"name", action, false});
		m.invoke(ob, new Object[]{"s-time", startTime, false});
		m.invoke(ob, new Object[]{"e-time", endTime, false});
		m.invoke(ob, new Object[]{"result", result.toString(), true});
		
		return result;
	}
}
