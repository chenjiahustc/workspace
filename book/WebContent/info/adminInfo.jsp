<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员管理首页</title>
	</head>
	<body>
		<h1>
			<font color="red">管理菜单</font>
		</h1>
		<s:a href="/book/authorityAdmin/listUser.action">读者管理</s:a>
		&nbsp;
		<s:a href="/book/authorityAdmin/listRoom.action">书籍管理</s:a>
		&nbsp;
		<s:a href="/book/authorityAdmin/listOrder.action">借阅管理</s:a>
		&nbsp;
		<s:a href="/book/authorityAdmin/adminService!loginOut">退出</s:a>

	</body>
</html>