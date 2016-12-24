package cn.pluto.www.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Configuration {
	private static String driver = "";
	private static String url = "";
	private static String username = "";
	private static String password = "";
	private static List<OrMappingClass> orMappingclassList = null;
	
	static {
		Document document = null;
		String filepath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "or_mapping.xml"; 
		try{
	        SAXReader reader = new SAXReader();  
	        document = reader.read(new File(filepath));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Element root = document.getRootElement();
		
		//获取jdbc配置
		Element jdbcElement = root.element("jdbc");
		List<Element> props = jdbcElement.elements("property");
		for(Element prop : props){
			if (prop.element("name").getText().equals("driver_class"))
				driver = prop.element("value").getText();
			else if (prop.element("name").getText().equals("url_path"))
				url = prop.element("value").getText();
			else if (prop.element("name").getText().equals("db_username"))
				username = prop.element("value").getText();
			else if (prop.element("name").getText().equals("db_password"))
				password = prop.element("value").getText();
			else
				;
		}
		
		//获取class元素数组
		List<Element> classList = root.elements("class");
		for(Element c : classList){
			OrMappingClass omc = new OrMappingClass();
			String name = c.element("name").getText();
			String table = c.element("table").getText();
			String id = c.element("id").element("name").getText();
			List<OrMappingProperty> propList = new ArrayList<OrMappingProperty>();
			
			List<Element> propEs = c.elements("property");
			for(Element propE : propEs){
				OrMappingProperty ormapp = new OrMappingProperty();
				ormapp.setName(propE.element("name").getText());
				ormapp.setColumn(propE.element("column").getText());
				ormapp.setType(propE.element("type").getText());
				ormapp.setLazy(propE.element("lazy").getText());	
				
				propList.add(ormapp);
			}
			
			omc.setName(name);
			omc.setTable(table);
			omc.setId(id);
			omc.setProperties(propList);
			
			
			orMappingclassList.add(omc); 
		}
	}
	
	public static String getDriver() {
		return driver;
	}
	public static void setDriver(String driver) {
		Configuration.driver = driver;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Configuration.url = url;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Configuration.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Configuration.password = password;
	}
	public static List<OrMappingClass> getOrMappingclassList() {
		return orMappingclassList;
	}
	public static void setOrMappingclassList(List<OrMappingClass> orMappingclassList) {
		Configuration.orMappingclassList = orMappingclassList;
	}
	
	
}
