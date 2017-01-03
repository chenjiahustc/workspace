import cn.pluto.www.LoginAction;
import cn.pluto.www.UserBean;
import cn.pluto.www.di.DependencyMappings;

public class DI_Test {

	public static void main(String[] args) {
		LoginAction la = (LoginAction) DependencyMappings.getBeanByName("loginAction");
		
		UserBean userBean = la.getUserBean();
		
		System.out.println("userID = " + userBean.getUserID());
		System.out.println("userName = " + userBean.getUserName());
		System.out.println("userPass = " + userBean.getUserPass());

	}

}
