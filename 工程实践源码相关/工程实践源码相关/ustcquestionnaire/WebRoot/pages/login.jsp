<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎来到心理评测问卷系统</title>
    
	
  </head>
  
  <body>
    <s:form action="login" theme="xhtml">
    	<s:textfield name="account" label="账户"></s:textfield>
    	<s:password name="passWord" label="密码"></s:password>
    	<s:submit value="登录"></s:submit>    	
    </s:form>
    <s:a href="pages/register.jsp">注册</s:a>
  </body>
</html>
