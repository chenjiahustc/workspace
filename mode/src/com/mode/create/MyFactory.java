package com.mode.create;

public class MyFactory {
	public MyInterface produce(String type){
		if("One".equals(type)){
			return new MyClassOne();
		}
		else if("Two".equals(type)){
			return new MyClassTwo();
		}
		else{
			System.out.println("not found type");
			return null;
		}
	}
}