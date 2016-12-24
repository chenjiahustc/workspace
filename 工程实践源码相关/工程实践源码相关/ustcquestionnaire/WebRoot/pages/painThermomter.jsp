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
    	<h1>心理痛苦温度计 </h1>
    	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;亲爱的患友：您好！首先非常感谢您对我院的信任，选择到我院进行治疗。我们全体医护人员衷心希望与您携手共抗病魔，并祝您早日康复！
    		在疾病的治疗和康复中，您可能会因为一些身体或心理上的不适而产生痛苦的体验。比如睡眠问题、疼痛、食欲不振、心烦心慌等。作为医护人员，我们非常希望能够了解您的痛苦并提供专业的服务。
    		请认真填写这份短小的问卷，如实告诉我们是什么原因或哪儿不舒服使您感到痛苦，以及痛苦的程度。只要您告诉我们，我们会在医疗中尽力减轻您的痛苦，给予您更多的人文关怀。</p>
    	<hr />
    </div>

    
    
    
    <div class="main" id="questions">
    	<form  action="painacceptaction" onsubmit="thank()" method="post">
    	<span>考场号：</span>
    	<input id="exam_id" type="text" name="exam_id" required="required" autofocus="autofocus"/>
    	
	    	<h2>请您填写个人基本信息</h2>
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
		<s:radio list="#{'男':'男','女':'女'}" name="sex"></s:radio>
    		<h3>首先请您选择最符合您一周所经历的平均痛苦水平的数字。（10表示极度痛苦，1表示没有痛苦）</h3>
    		<input type="number" name="painDegree" max="10" min="1" value="5"/>
    		<br />
    		<h2>接着，请指出下列哪些选项是引起您痛苦的原因？</h2>	
    		<ul>
    			<li>实际问题</li>
    			<s:checkboxlist name="question1" list="#{'选择答案为1':'无时间精力照顾孩子/老人', '选择答案为2':'无时间精力做家务','选择答案为3':'经济问题','选择答案为4':'交通出行','选择答案为5':'工作/上学','选择答案为6':'周围环境'}"></s:checkboxlist>
    			
    			<li>身体问题</li>
    			<s:checkboxlist name="question2" list="#{'选择答案为1':'外表/形体', '选择答案为2':'洗澡/穿衣','选择答案为3':'呼吸','选择答案为4':'排尿改变','选择答案为5':'便秘','选择答案为6':'腹泻','选择答案为7':'进食','选择答案为8':'疲乏','选择答案为9':'水肿','选择答案为10':'发烧','选择答案为11':'头晕','选择答案为12':'消化不良','选择答案为13':'口腔疼痛','选择答案为14':'恶心','选择答案为15':'鼻子干燥/充血','选择答案为16':'疼痛','选择答案为17':'性','选择答案为18':'皮肤干燥','选择答案为19':'手脚麻木','选择答案为20':'身体活动受限制'}"></s:checkboxlist>
    			
    			<li>交往问题</li>
    			<s:checkboxlist name="question3" list="#{'选择答案为1':'与老人/孩子相处', '选择答案为2':'与伴侣相处','选择答案为3':'与亲友先出','选择答案为4':'与医护人员相处'}"></s:checkboxlist>
    			
    			
    			<li>情绪问题</li>
    			<s:checkboxlist name="question4" list="#{'选择答案为1':'抑郁', '选择答案为2':'恐惧','选择答案为3':'孤独','选择答案为4':'紧张','选择答案为5':'悲伤','选择答案为6':'担忧','选择答案为7':'对日常活动丧失兴趣','选择答案为8':'睡眠问题','选择答案为9':'记忆力下降/注意力不集中'}"></s:checkboxlist>
    			
    			<li>信仰/宗教问题</li>
    		
    			<s:checkboxlist name="question5" list="#{'选择答案为1':'信仰/宗教问题' }"></s:checkboxlist>
    		
    		
    		</ul>
    		<input id="submit" class="button" type="submit" value="提交"  />
			<input id="reset" class="button" type="reset" value="重置" />
    		
    		
    	</form>
    </div>
     
    <div class="foot"> 友情链接：<a href="http://www.baidu.com" >百度</a> </div>
  </body>
</html>
