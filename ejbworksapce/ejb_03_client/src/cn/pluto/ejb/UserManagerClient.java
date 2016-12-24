package cn.pluto.ejb;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UserManagerClient {

	public static void main(String[] args) throws NamingException {
		Properties props= new Properties();  
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");  
		props.setProperty("java.naming.provider.url", "jnp://localhost");  
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");  
		
		InitialContext context = new InitialContext(props);
		
		UserManager userManager = (UserManager)context.lookup("UserManagerBean/remote");
		User user = new User();
		user.setUsername("Zhangsan");
		user.setPassword("zhangsan");
		
		userManager.addUser(user);
		
		System.out.println("user has been saved, its id is: " + user.getId());
	
		
		
	}

}
