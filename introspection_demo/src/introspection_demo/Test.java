package introspection_demo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws IntrospectionException, InvocationTargetException,
		IllegalAccessException{
		User user = new User("zhangshu", 21);
		String propertyName = "name";
		
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, user.getClass());
		Method readMethod = pd.getReadMethod();
		Object invoke = readMethod.invoke(user, null);
		System.out.println("name : " + invoke);
		pd.getWriteMethod().invoke(user,  "lisi");
		invoke = readMethod.invoke(user,  null);
		System.out.println("name : " + invoke);
		
		BeanInfo beanInfo = Introspector.getBeanInfo(user.getClass(), Object.class);
		System.out.println("所有属性描述：");
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor p : pds){
			System.out.println(p.getName());
		}
		
		System.out.println("所有方法描述：");  
		for (MethodDescriptor methodDescriptor: beanInfo.getMethodDescriptors()) {  
			System.out.println(methodDescriptor.getName());  
		}
	}
}
