<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>读者注册</title>
	</head>
	<body>
		<%@ include file="/info/adminInfo.jsp" %>
		<h1>
			<font color=-"red">添加读者</font>
		</h1>
		<s:form action="userService">
			<s:textfield name="user.username" label="用户名"></s:textfield>
			<s:password name="user.password" label="密码"></s:password>
			<s:textfield name="user.mobile" label="手机号码"></s:textfield>
			<s:textfield name="user.email" label="邮箱"></s:textfield>
			<s:submit method="saveUser" value="增 加"></s:submit>
		</s:form>
	</body>
</html>