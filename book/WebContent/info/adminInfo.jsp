<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����Ա������ҳ</title>
	</head>
	<body>
		<h1>
			<font color="red">����˵�</font>
		</h1>
		<s:a href="/book/authorityAdmin/listUser.action">���߹���</s:a>
		&nbsp;
		<s:a href="/book/authorityAdmin/listRoom.action">�鼮����</s:a>
		&nbsp;
		<s:a href="/book/authorityAdmin/listOrder.action">���Ĺ���</s:a>
		&nbsp;
		<s:a href="/book/authorityAdmin/adminService!loginOut">�˳�</s:a>

	</body>
</html>