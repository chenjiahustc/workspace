<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>读者所预定书籍列表</title>
		<script type="text/javascript">
function del() {
	if (confirm("你确定要借阅该书籍吗?")) {
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
					所借阅的书籍列表
				</center> </font>
		</h1>
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
				<!-- <td>
					房间状态
				</td> -->
				<td>
					操作
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
						<s:if test="#room.status == 0">空房</s:if>
						<s:else>有客人</s:else>
					</td> -->
					<td>
						<s:a
							href="/hotel/recorderService!delete?book.bookid=%{#book.bookid}"
							onclick="return del();">退阅</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
