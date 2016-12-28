<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>增加入住信息</title>
		<script type="text/javascript">
function sav() {
	if (confirm("你确定要借阅该书籍吗?")) {
		return true;
	}
	return false;
}
</script>
	</head>
	<body>
 	<%@include file="/info/userInfo.jsp"%>
		<h1>
			<font color="red"><center> 
					新增入住信息 
				</center> </font>
		</h1>
		<table border="1" width="80%" align="center">
			<tr>
				<td colspan="5">
					<h2>
						<font color="red"><center> 
								<br>书籍列表 
							</center> </font>
					</h2>
				</td>
			</tr>
			<tr>
				<td> 
					书籍号
				</td>
				<td> 
					书籍名
				</td>
				<td>
					书籍作者
				</td>
				<td>
					书籍简介
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="#request.listBook" id="book">
				<tr>
					<td>
						<s:property value="#book.roomid" />
					</td>
					<td>
						<s:property value="#room.name" />
					</td>
					<td>
						<s:property value="#room.price" />
					</td>
					<td>
						<s:property value="#room.category" />
					</td>
					<td>
						空闲
						<s:else>已入住</s:else>
					</td>
					<td>
						<s:a href="saveOrder!add?order.roomid=%{#room.roomid}&room.roomid=%{#room.roomid}"
							onclick="return sav();">入住</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>