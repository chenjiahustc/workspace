package cn.pluto.www;

import cn.pluto.www.xml.ActionController;

public class ActionTest {

	public static void main(String[] args) {
		ActionController ac = null;
		
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		ac = new ActionController(path + "controller.xml");
		String strs[] = {"login", "register"};
		for (String str : strs){
			System.out.println(ac.checkAction(str));
			System.out.println(ac.getActionClassName(str));
			System.out.println(ac.getActionClassMethod(str));
			String irName = ac.getActionInterceptorRef(str);
			if(irName != null){
				System.out.println(irName);
				System.out.println(ac.getInterceptorClass(irName));
				System.out.println(ac.getInterceptorClassMethod(irName));
			}
			System.out.println(ac.getResultType(str, "success"));
			System.out.println(ac.getResultValue(str, "success"));
			System.out.println(ac.getResultType(str, "fail"));
			System.out.println(ac.getResultValue(str, "fail"));
		}
		
		return ;

	}

}
