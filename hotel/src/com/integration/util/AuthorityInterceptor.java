package com.integration.util;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.integration.entity.Reader;
@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {
	@SuppressWarnings("unchecked")
	@Override
	//µÇÂ¼À¹½ØÆ÷
	public String intercept(ActionInvocation invocation) throws Exception {	
		ActionContext context = invocation.getInvocationContext();	
		Map session = context.getSession();		
		Reader reader = (Reader)session.get("reader");		
		if(reader!=null){
			return invocation.invoke();
		}		
		context.put("message", "Äú»¹Ã»ÓÐµÇÂ¼£¬ÇëµÇÂ¼ÏµÍ³¡£");		
		return Action.LOGIN;
	}
}
