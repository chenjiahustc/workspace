<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�����޸�����</title>
	</head>
	<body>
		<h1>
			<font color="red">�޸�����</font>
		</h1>
		<s:form action="readerService">
			<table>
				<tr>
					<td>
						<s:hidden name="reader.readerid" value="%{reader.readerid}"></s:hidden>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield readonly="true" name="reader.username"
							value="%{reader.username}" label="������"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<!--<s:password name="user.password" value="%{user.password}" label="����"></s:password>-->
						<s:textfield name="reader.password" value="%{reader.password}"
							label="����"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="reader.mobile" value="%{reader.mobile}"
							label="�ֻ�����"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="reader.email" value="%{reader.email}" label="�����ַ"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:submit method="updateReader" value="�޸�"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
