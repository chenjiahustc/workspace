<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>护士调查问卷</title>
<link  rel="stylesheet" type="text/css" href="my1.css"/>
<script src="function.js"></script>
</head>
  <body>
    <div class="head">
    	<h1>患者问卷</h1>	
    	<hr />
    </div>

    
    
    
    <div class="main" id="questions">
    	<form  action="patientacceptaction" onsubmit="thank()" method="post" >
    	<span>考场号：</span>
      <input id="exam_id" type="text" name="exam_id" required="required" autofocus="autofocus"/>
      
    		<h2>请填写患者个人基本信息</h2>
		姓名：
		<input name="name" type="text" size="100" required="required" autofocus="autofocus"/>
		<br /><br />
		工号：
		<input type="text" name="work_number" required="required" />
		<br /><br />
		电话：
		<input name="telphone" type="text" required="required" />
		<br /><br />
		年龄：
		<input name="age" type="number" max="100" min="0"  value="20" required="required"/>
		<br /><br />
		性别:
		<s:radio list="#{'male':'男','female':'女'}" name="sex"></s:radio>
			<h2>请评定患者最近1周内出现以下行为表现的频率</h2>
    		<ol>
    		<li>患者是否出现过一阵阵哭泣?</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question1" ></s:radio>
    		
    		<li>患者晚上是否烦躁不安，无法休息？</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question2" ></s:radio>
    		
    		<li>当你和患者说话时，他/她是否会避开你的目光？</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question3" ></s:radio>
    		
    		<li>患者是否会突然大哭不止？</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question4" ></s:radio>
    		
    		<li>患者是否有疼痛的表示？</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question5" ></s:radio>
    		
    		<li> 患者是否容易生气？</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question6" ></s:radio>
    		
    		<li>患者是否拒绝与人交往？</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question7" ></s:radio>
    		
    		<li>患者是否显得烦躁和坐立不安？</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question8" ></s:radio>
    		
    		<li>患者是否呆坐不动？</li>
    			<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question9" ></s:radio>
    		
    		<li>患者白天是否会找些事情做</li>
    	    	<s:radio list="#{'选择答案为0':'最近1周每天都这样<br />','选择答案为1':'最近1周4-6天是这样<br />','选择答案为2':'最近1周1-4天是这样<br />','选择答案为3':'最近1周从没有这样<br />'}" name="question10" ></s:radio>
    	
    		</ol>	
   	
    		<input id="submit" class="button" type="submit" value="提交"  />
			<input id="reset" class="button" type="reset" value="重置" />
    	</form>
    </div>
     
    <div class="foot"> 友情链接：<a href="http://www.baidu.com" >百度</a> </div>
  </body>
</html>
