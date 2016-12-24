package cn.pluto.www;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler implements InvocationHandler{
	private Object targetObject;
	
	public HelloWorldHandler(Object targetObject){
		this.targetObject = targetObject;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		System.out.println("before method called...");
		//obj.sayHelloWorld();
		Object result = method.invoke(this.targetObject, args);
		System.out.println("after method called...");
		
		return result;
	}
}
