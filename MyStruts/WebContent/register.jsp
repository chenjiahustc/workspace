<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册！</title>
</head>
<body>
   <h1>
			<font>用户注册</font>
		</h1>
		<s:form action="register">
			<s:textfield name="user.username" label="用户名"></s:textfield>
			<s:password name="user.password" label="密码"></s:password>
			<s:textfield name="user.mobile" label="联系电话"></s:textfield>
			<s:textfield name="user.email" label="电子邮箱"></s:textfield>
			<s:submit method="register" value="注 册"></s:submit>
		</s:form>
</body>
</html>