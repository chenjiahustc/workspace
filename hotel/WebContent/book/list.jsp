<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�鼮�б�</title>
		<script type="text/javascript">
function del() {
	if (confirm("ȷ��ɾ���鼮��Ϣ��?")) {
		return true;
	}
	return false;
}
</script>
	</head>
	<body>
		<%@include file="/info/adminInfo.jsp"%>
		<h1>
			<font color="red"><center>
					�鼮�б�
				</center> </font>
		</h1>
		<s:a href="/hotel/book/add.jsp">�����鼮</s:a>
		<table border="1" width="80%" align="center">
			<tr>
				<td>
					�鼮���
				</td>
				<td>
					�鼮����
				</td>
				<td>
					�鼮����
				</td>
				<td> 
					�鼮���
				</td>
				<td>
					�鼮״̬
				</td>
				<td>
					ɾ��
				</td>
				<td>
					����
				</td>
			</tr>
			<s:iterator value="#request.list" id="book">
				<tr>
					<td>
						<s:property value="#book.bookid" />
					</td>
					<td>
						<s:property value="#book.name" />
					</td>
					<td>
						<s:property value="#book.author" />
					</td>
					<td>
						<s:property value="#book.briefIntroduction" />
					</td>
					<td>
						<s:if test="#book.status == 0">����</s:if>
						<s:else>�ѽ���</s:else>
					</td>
					<td>
						<s:a href="deleteRBook.action?book.bookid=%{#book.bookid}"
							onclick="return del();">delete</s:a>
					</td>
					<td>
						<s:a href="updatePBook.action?book.bookid=%{#book.bookid}">update</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
