<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>黄页</title>
	</head>
	<body>
		<h1>
			<font color="red">操作菜单</font>
		</h1>
		<s:a href="/StrutsApp/listUserAction!listUser">查看用户联系方式</s:a>
		&nbsp;
		<s:a href="/StrutsApp/userAction!logout">退出</s:a>
	</body>
</html>