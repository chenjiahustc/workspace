<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改书籍信息</title>
	</head>
	<body>
		<%@include file="/info/adminInfo.jsp"%>
		<h1>
			<font color="red"><center>
					修改书籍
				</center> </font>
		</h1>
		<s:form action="updateBook">
			<table>
				<tr>
					<td>
						<s:hidden name="book.bookid" value="%{book.bookid}"></s:hidden>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="book.name" value="%{book.name}" label="书籍名称"
							readonly="true"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="book.author" value="%{book.author}"
							label="书籍作者"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="book.briefIntroduction" value="%{book.briefIntroduction}"
							label="书籍简介"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<tr>
							<td class="tdLabel">
								书籍状态:
							</td>
							<s:if test="book.status == 0">
								<td>
									<select name="book.status">
										<option value="0" selected="selected">
											未借阅
										</option>
										<option value="1">
											已借阅
										</option>
									</select>
								</td>
							</s:if>
							<s:else>
								<td>
									<select name="book.status">
										<option value="0">
											未借阅
										</option>
										<option value="1" selected="selected">
											已借阅
										</option>
									</select>
								</td>
							</s:else>
						</tr>
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