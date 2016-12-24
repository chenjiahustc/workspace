package cn.pluto;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ServletDemo1 extends GenericServlet{
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{
		OutputStream out = response.getOutputStream();
		
		out.write("hello servlet!!!".getBytes());
	}
	
}