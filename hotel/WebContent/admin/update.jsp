<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改读者资料</title>
	</head>
	<body>
		<%@include file="/info/adminInfo.jsp"%>
		<h1>
			<font color="red"><center>
					修改读者
				</center> </font>
		</h1>
		<s:form action="updateReader">
			<table>
				<tr>
					<td>
						<s:hidden name="reader.readerid" value="%{reader.readerid}"></s:hidden>

					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="reader.username" value="%{reader.username}"
							label="用户名"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<!--<s:password name="user.password" value="%{user.password}" label="密码"></s:password>-->
						<s:textfield name="reader.password" value="%{reader.password}"
							label="密码"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="reader.mobile" value="%{reader.mobile}"
							label="手机号码"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="reader.email" value="%{reader.email}" label="邮箱地址"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:submit value="修改"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>