<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>������ס��Ϣ</title>
		<script type="text/javascript">
function sav() {
	if (confirm("��ȷ��Ҫ���ĸ��鼮��?")) {
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
					������ס��Ϣ 
				</center> </font>
		</h1>
		<table border="1" width="80%" align="center">
			<tr>
				<td colspan="5">
					<h2>
						<font color="red"><center> 
								<br>�鼮�б� 
							</center> </font>
					</h2>
				</td>
			</tr>
			<tr>
				<td> 
					�鼮��
				</td>
				<td> 
					�鼮��
				</td>
				<td>
					�鼮����
				</td>
				<td>
					�鼮���
				</td>
				<td>
					����
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
						����
						<s:else>����ס</s:else>
					</td>
					<td>
						<s:a href="saveOrder!add?order.roomid=%{#room.roomid}&room.roomid=%{#room.roomid}"
							onclick="return sav();">��ס</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>