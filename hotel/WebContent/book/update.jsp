<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�޸��鼮��Ϣ</title>
	</head>
	<body>
		<%@include file="/info/adminInfo.jsp"%>
		<h1>
			<font color="red"><center>
					�޸��鼮
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
						<s:textfield name="book.name" value="%{book.name}" label="�鼮����"
							readonly="true"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="book.author" value="%{book.author}"
							label="�鼮����"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="book.briefIntroduction" value="%{book.briefIntroduction}"
							label="�鼮���"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						<tr>
							<td class="tdLabel">
								�鼮״̬:
							</td>
							<s:if test="book.status == 0">
								<td>
									<select name="book.status">
										<option value="0" selected="selected">
											δ����
										</option>
										<option value="1">
											�ѽ���
										</option>
									</select>
								</td>
							</s:if>
							<s:else>
								<td>
									<select name="book.status">
										<option value="0">
											δ����
										</option>
										<option value="1" selected="selected">
											�ѽ���
										</option>
									</select>
								</td>
							</s:else>
						</tr>
					</td>
				</tr>
				<tr>
					<td>
						<s:submit value="�޸�"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>