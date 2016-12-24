package cn.pluto.www;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pluto.www.xml.ActionController;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("*.scaction")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strs[] = request.getRequestURI().split("/");
		String urls = strs[strs.length - 1];
		String action = urls.substring(0, urls.length() - 9);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String result = null;
		
		ServletContext context = getServletContext();
//		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		ActionController ac = new ActionController(path + "controller.xml");
		ActionController ac = null;
		ac = (ActionController)context.getAttribute("actioncontroller");
		
		if (ac == null){
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			ac = new ActionController(path + "controller.xml");
			context.setAttribute("actioncontroller", ac);
			System.out.println("load actioncontroller");
		}
		
		if (!ac.checkAction(action)){
			response.getWriter().append("action: " + action + " is not found!");
			return;
		}
		
		boolean hasIR = false;
		if (!ac.hasInterceptor(action)){
			hasIR = true;
		}
		
		String classname = ac.getActionClassName(action);
		String method = ac.getActionClassMethod(action);
		
		if (!ac.hasInterceptor(action)){
			Class cl = null;
			Object ob = null;
			Method m = null;
			
			try{
				cl = Class.forName(classname);
				ob = cl.newInstance();
				m = cl.getMethod(method, new Class[]{String.class, String.class});
			} catch(Exception e){
				e.printStackTrace();
			}
			
			try{
				result = (String)m.invoke(ob, new String[]{username, password});	
			} catch(Exception e){
				e.printStackTrace();
			}
		}else{
			String irName = ac.getActionInterceptorRef(action);
			String interceptorClass = ac.getInterceptorClass(irName);
			String interceptorMethod = ac.getInterceptorClassMethod(irName);
			Class cl = null;
			Object obj = null;
			Method m = null;
			
			try{
				cl = Class.forName(classname);
				obj = (LoginActionInterface)cl.newInstance();
			} catch(Exception e){
				e.printStackTrace();
			}
			
			ActionHandler handler = new ActionHandler(obj, action, interceptorClass, interceptorMethod);
			
			Object proxy = Proxy.newProxyInstance(
					obj.getClass().getClassLoader(), 
					obj.getClass().getInterfaces(), 
					handler);
			
			//下面两try代码相当于result = ((LoginActionInterface)proxy).login(username, password);
			try{
				cl = proxy.getClass();
				m = cl.getMethod(method, new Class[]{String.class, String.class});
			} catch(Exception e){
				e.printStackTrace();
			}
			
			try{
				result = (String)m.invoke(proxy, new String[]{username, password});
			} catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println(result);
			
		}
		
		String type = ac.getResultType(action, result);
		String value = ac.getResultValue(action, result);
		if(value == null){
			response.getWriter().append("result: " + result + " is not found!");
			return;
		}

		if(type.equals("forward")){
			if ("jsp".equals(value.substring(value.length() - 3))){
				RequestDispatcher dispatcher = context.getRequestDispatcher("/" + value);
				dispatcher.forward(request, response);
			} else{
				String html = null;
				//String filepath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "success_view.xml";
				String filepath = context.getRealPath("/" + value);
				ConvertXmlToHtml cxt = new ConvertXmlToHtml(filepath);
				html = cxt.getHtml();
				
				response.getWriter().append(html);
				
				
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/" + value);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
