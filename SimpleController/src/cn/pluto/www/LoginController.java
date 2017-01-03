package cn.pluto.www;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pluto.www.di.DependencyMappings;

/**
 * Servlet implementation class LoginController
 */
//@WebServlet("*.scaction")
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
		
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		ActionController ac = new ActionController(path + "controller.xml");
		if (!ac.checkAction(action)){
			response.getWriter().append("action: " + action + " is not found!");
			return;
		}
		String classname = ac.getActionClassName(action);
		String method = ac.getActionClassMethod(action);
		
		Class cl = null;
		Object ob = null;
		Method m = null;
		
		try{
			//cl = Class.forName(classname);
			//ob = cl.newInstance();
			ob = DependencyMappings.getBeanByName(classname);
			cl = ob.getClass();
			m = cl.getMethod(method, new Class[]{String.class, String.class});
		} catch(Exception e){
			e.printStackTrace();
		}
		
		String result = null;
		try{
			result = (String)m.invoke(ob, new String[]{username, password});
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		//System.out.println(result);
		
		String type = ac.getResultType(action, result);
		String value = ac.getResultValue(action, result);
		if(value == null){
			response.getWriter().append("result: " + result + " is not found!");
			return;
		}
		//System.out.println(value);
		if(type.equals("forward")){
			ServletContext context = getServletContext();
			//System.out.println("/" + value);
			RequestDispatcher dispatcher = context.getRequestDispatcher("/" + value);
			
			dispatcher.forward(request, response);
		} else {
			//System.out.println(request.getContextPath() + "/" + value);
			response.sendRedirect(request.getContextPath() + "/" + value);
			//response.sendRedirect("http://localhost:8080/pages/fail.jsp");
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
