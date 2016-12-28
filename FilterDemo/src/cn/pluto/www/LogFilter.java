package cn.pluto.www;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/*")
public class LogFilter implements Filter {

	
	private FilterConfig fConfig;
    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.fConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		ServletContext context = this.fConfig.getServletContext();
		long before = System.currentTimeMillis();
		System.out.println("��ʼ����...");
		System.out.println("" + ((HttpServletRequest)request).getServletPath());
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		
		System.out.println("���˽���...");
		System.out.println("���󱻶�λ�� " + ((HttpServletRequest)request).getRequestURI() + " ����ʱ��Ϊ " + (after - before));
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig = fConfig;
	}

}
