<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>×¢²á£¡</title>
</head>
<body>
   <h1>
			<font>ÓÃ»§×¢²á</font>
		</h1>
		<s:form action="register">
			<s:textfield name="user.username" label="ÓÃ»§Ãû"></s:textfield>
			<s:password name="user.password" label="ÃÜÂë"></s:password>
			<s:textfield name="user.mobile" label="ÁªÏµµç»°"></s:textfield>
			<s:textfield name="user.email" label="µç×ÓÓÊÏä"></s:textfield>
			<s:submit method="register" value="×¢ ²á"></s:submit>
		</s:form>
</body>
</html>