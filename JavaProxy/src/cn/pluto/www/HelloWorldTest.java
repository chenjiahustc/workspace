package cn.pluto.www;

import java.lang.reflect.Proxy;

public class HelloWorldTest {

	public static void main(String[] args) {
		//被代理对象
		HelloWorld obj = new HelloWorldImpl();
		//代理调度器
		HelloWorldHandler handler = new HelloWorldHandler(obj);
		//代理
		HelloWorld proxy = (HelloWorld)Proxy.newProxyInstance(   
				obj.getClass().getClassLoader(),    
                obj.getClass().getInterfaces(),    
                handler);  
		//obj.sayHelloWorld();
		proxy.sayHelloWorld();

	}

}
