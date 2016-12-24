package cn.pluto.ejb;

import javax.ejb.Remote;

@Remote
public interface UserManager {
	public void addUser(User user);
}
