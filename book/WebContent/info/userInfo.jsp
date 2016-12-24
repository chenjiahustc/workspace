<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>读者管理首页</title>
	</head>
	<body>
		<h1>
			<font color="red">操作菜单</font>
		</h1>
		<s:a href="userService!userUpdateInfo">修改密码</s:a>
		&nbsp
		<s:a href="#">借阅书籍</s:a>
		&nbsp
		<s:a href="#">查看借阅信息</s:a>
		&nbsp
		<s:a href="userService!logout">退出</s:a>
	</body>
</html>