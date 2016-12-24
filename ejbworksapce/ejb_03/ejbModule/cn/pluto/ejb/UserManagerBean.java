package cn.pluto.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
@Remote
@Local
public class UserManagerBean implements UserManager {
	public void addUser(User user){
		System.out.println("User[username=" + user.getUsername() + "] had been saved");
		user.setId(10);
	}
}
