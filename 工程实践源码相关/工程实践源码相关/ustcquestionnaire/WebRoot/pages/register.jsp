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
    
    <title>欢迎注册</title>
    
	
  </head>
  
  <body>
    <s:form action="register" theme="xhtml">
        <s:textfield name="account" label="账户" ></s:textfield>
    	<s:password name="passWord" label="密码" ></s:password>  
    	<s:textfield name="name" label="姓名"></s:textfield>  	
    	<s:textfield name="telphone" label="电话"></s:textfield>
    	<s:textfield name="mail" label="邮箱"></s:textfield>    	
    	<s:submit value="注册"></s:submit>
    </s:form>
  </body>
</html>
