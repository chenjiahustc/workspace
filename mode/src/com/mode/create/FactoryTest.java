package com.mode.create;

public class FactoryTest {

	public static void main(String[] args) {
		MyFactory factory = new MyFactory();
		MyInterface myi1 = factory.produce("One");
		myi1.print();
		MyInterface myi2 = factory.produce("Two");
		myi2.print();
	}

}
