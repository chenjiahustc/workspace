package cn.pluto.www;

public class ClassLoaderTest {

	public static void main(String[] args) {
		System.out.println(String.class.getClassLoader());
		System.out.println(com.sun.crypto.provider.DESedeKeyFactory.class.getClassLoader().getClass().getName());
	}

}
