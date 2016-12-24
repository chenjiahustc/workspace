package cn.pluto.www;

import java.lang.reflect.Proxy;

public class HelloWorldTest {

	public static void main(String[] args) {
		//���������
		HelloWorld obj = new HelloWorldImpl();
		//���������
		HelloWorldHandler handler = new HelloWorldHandler(obj);
		//����
		HelloWorld proxy = (HelloWorld)Proxy.newProxyInstance(   
				obj.getClass().getClassLoader(),    
                obj.getClass().getInterfaces(),    
                handler);  
		//obj.sayHelloWorld();
		proxy.sayHelloWorld();

	}

}
