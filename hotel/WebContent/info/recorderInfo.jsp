<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>������Ԥ���鼮�б�</title>
		<script type="text/javascript">
function del() {
	if (confirm("��ȷ��Ҫ���ĸ��鼮��?")) {
		return true;
	}
	return false;
}
</script>
	</head>
	<body>
		<%@include file="/info/readerInfo.jsp"%>
		<h1>
			<font color="red"><center>
					�����ĵ��鼮�б�
				</center> </font>
		</h1>
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
				<!-- <td>
					����״̬
				</td> -->
				<td>
					����
				</td>
			</tr>
			<s:iterator value="#request.listReaderBook" id="book">
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
					<!-- <td>
						<s:if test="#room.status == 0">�շ�</s:if>
						<s:else>�п���</s:else>
					</td> -->
					<td>
						<s:a
							href="/hotel/recorderService!delete?book.bookid=%{#book.bookid}"
							onclick="return del();">����</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
