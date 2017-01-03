package cn.pluto.www.di;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DependencyMappings {
	private static List<Bean> beanList = new ArrayList<Bean>();

	static{
		String filepath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "di.xml"; 
		Document document = null;
		try{
			SAXReader reader = new SAXReader();
			document = reader.read(new File(filepath));
		} catch(Exception e){
			e.printStackTrace();
		}
		
		Element root = document.getRootElement();
		List<Element> beanElements = root.elements("bean");
		
		for(Element element : beanElements){
			Bean bean = getBean(element);
			beanList.add(bean);
		}
	}
	
	public static Object getBeanByName(String name){
		Object obj = null;
		Bean targetBean = null;
		
		for(Bean bean : beanList){
			if(name.equals(bean.getName()))
				targetBean = bean;
		}
		
		Class cl = null;
		try{
			cl = Class.forName(targetBean.getClassName());
			obj = cl.newInstance();
			
			for(Property prop : targetBean.getProperties()){
				PropertyDescriptor pd = new PropertyDescriptor(prop.getName(), cl);
				Method writeMethod = pd.getWriteMethod();
				if (!"".equals(prop.getValue())){
					if(pd.getClass().equals(Integer.class))
						writeMethod.invoke(obj, Integer.valueOf(prop.getValue()).intValue());
					else
						writeMethod.invoke(obj, prop.getValue());
				}else if (!"".equals(prop.getRefClass())){
					writeMethod.invoke(obj,	getBeanByName(prop.getRefClass()));
				}else
					;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println("get bean : " + name + " success...");
		return obj;
	}
	
	public static Bean getBean(Element e){
		Bean bean = new Bean();
		bean.setName(e.elementText("name"));
		bean.setClassName(e.elementText("class"));
		List<Property> properties = new ArrayList<Property>();
		
		List<Element> pElements = e.elements("property");
		for(Element pe : pElements){
			Property p = getProperty(pe);
			properties.add(p);
		}
				
		bean.setProperties(properties);
		
		return bean;
	}
	
	public static Property getProperty(Element e){
		Property property = new Property();
		property.setName(e.elementText("name"));
		property.setValue(e.elementText("value"));
		property.setRefClass(e.elementText("ref-class"));
		
		return property;
	}
}
