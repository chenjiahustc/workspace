<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>增加书籍</title>
	</head>
	<body>
		<%@include file="/info/adminInfo.jsp"%>
		<h1>
			<font color="red">增加书籍</font>
		</h1>
		<s:form action="saveBook">
			<s:textfield name="book.name" label="书籍名称"></s:textfield>
			<s:textfield name="book.author" label="书籍作者"></s:textfield>
			<s:textfield name="book.briefIntroduction" label="简介"></s:textfield>
			<tr>
				<td class="tdLabel">
					书籍状态:
				</td>
				<td>
					<select name="book.status">
						<option value="0" selected="selected">
							空闲
						</option>
						<option value="1">
							已借阅
						</option>
					</select>
				</td>
			</tr>
			<s:submit value="增 加"></s:submit>
		</s:form>
	</body>
</html>