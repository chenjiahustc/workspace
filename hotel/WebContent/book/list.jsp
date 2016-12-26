<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>书籍列表</title>
		<script type="text/javascript">
function del() {
	if (confirm("确定删除书籍信息吗?")) {
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
					书籍列表
				</center> </font>
		</h1>
		<s:a href="/hotel/book/add.jsp">增加书籍</s:a>
		<table border="1" width="80%" align="center">
			<tr>
				<td>
					书籍序号
				</td>
				<td>
					书籍名称
				</td>
				<td>
					书籍作者
				</td>
				<td> 
					书籍简介
				</td>
				<td>
					书籍状态
				</td>
				<td>
					删除
				</td>
				<td>
					更新
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
						<s:if test="#book.status == 0">空闲</s:if>
						<s:else>已借阅</s:else>
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
