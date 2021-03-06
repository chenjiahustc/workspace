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
<title>神经功能缺损量表</title>
<link  rel="stylesheet" type="text/css" href="my1.css"/>
<script src="function.js"></script>
</head>
  <body>
    <div class="head">
    	<h1>神经功能缺损量表</h1>
    	<p>&nbsp;&nbsp;&nbsp;&nbsp;请按照顺序填写下列表项，每个项目检查完毕要记录结果。不要返回前面改变得分。遵循每一项检查的指导。得分要反映患者做了什么。
    	而不是临床医生认为患者能做什么。医生要一边检查一边记录，快速评定。除非特别说明，患者不应被辅导</p>
    	<hr />
    </div>

    
    
    
    <div class="main" id="questions">
    	<form action="nihssacceptaction" onsubmit="thank()" method="post" >
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
		<s:radio list="#{'male':'男','female':'女'}" name="sex"></s:radio>
		<h2>请填写下列问题</h2>
    		<ol>
    		<li>意识水平：即因气管插管、语言障碍、口腔气管创伤及绷带包扎等，不能全面评价，检查者也必须选择1个反应。只有在伤害性刺激不能引起患者任何活动时，才能记3分</li>
    			<s:radio list="#{'选择答案为0':'清醒；反应灵敏<br />','选择答案为1':'不清醒；轻微刺激能唤醒，可遵从命令、回答问题、做出反应。<br />','选择答案为2':'不清醒；需反复刺激才有注意，或者反应迟钝需要强烈或疼痛的刺激才有活动（非刻板的）<br />','选择答案为3':'仅有反射性活动或植物效应或完全无反应、软瘫、无反射<br />'}" name="question1" ></s:radio>
    		<li>意识水平提问：询问患者当前月份及其年龄。回答必须正确－不能按接近程度给予部分打分。不能理解问题的失语和昏睡者记 2 分。因气管插管、口腔气管创伤、任何原因引起的严重构音障碍、语言障碍或不是继发于失语的任何其他原因，导致不能言语，记 1 分。仅对最初回答评分。检查者不能给予其言语或非言语的提示。</li>
    			<s:radio list="#{'选择答案为0':'两个问题回答均正确。<br />','选择答案为1':'一个问题回答正确。<br />','选择答案为2':'两个问题回答均不正确。<br />'}" name="question2" ></s:radio>
    		
    		<li>意识水平指令：先让患者睁眼和闭眼，再让患者非瘫痪侧握拳和伸掌。如果手不能使用，用另一种一步指令代替。有明确尝试但因为无力而不能完成的也算正确。若患者对指令无反应，检查者要给予演示（打手势），然后根据结果（如：遵从了 0 个、1个或 2 个指令）打分。有创伤、截肢或其他生理障碍者，应予适当的一步指令。仅对最初反应评分。</li>
    			<s:radio list="#{'选择答案为0':'两项任务执行均正确。<br />','选择答案为1':'一项任务执行正确。<br />','选择答案为2':' 两项任务执行均不正确。<br />'}" name="question3" ></s:radio>
    		
    		<li>最佳凝视：只测试水平眼球运动。对随意或反射性（眼头反射）眼球运动记分，但不要做冷热水试验。若患者的共轭性眼球偏斜能被随意或反射性活动克服，记 1 分。若为孤立的周围神经麻痹（Ⅲ、Ⅳ、Ⅵ颅神经），记 1 分。对所有失语者，凝视是可以检查的。有眼球创伤、绷带包扎、早已失明或有其他视力或视野损害者，应当检查其反射性运动，这由检查者来决定。与患者的目光接触，然后从一侧向另一侧移动，偶尔能发现部分性凝视麻痹。</li>
    		    <s:radio list="#{'选择答案为0':'正常<br />','选择答案为1':'部分性凝视麻痹；单眼或双眼凝视异常，但无强迫偏斜或完全凝视麻痹。<br />','选择答案为2':'强迫偏斜，或不能被头眼反射克服的完全凝视麻痹。<br />'}" name="question4" ></s:radio>
    		
    		
    		<li>视野：用对诊法检查视野（上下象限），要正确选用指数或视威胁。可引导患者。但若能正确地看向有手指活动的那一侧，记为正常。若单眼盲或眼球摘除，按剩余的那一只眼评分。如发现明确的不对称，包括象限盲，记 1 分。若全盲，无论什么原因导致，记 3 分。此时做双侧同时刺激，如果有视觉消退，记 1 分，结果用于问题 11。</li>
    			<s:radio list="#{'选择答案为0':'无视野缺损。<br />','选择答案为1':'部分偏盲。<br />','选择答案为2':'完全偏盲。<br />','选择答案为3':'双侧偏盲（盲，包括皮质盲）。<br />'}" name="question5" ></s:radio>
    		
    		<li>面瘫：言语指令或动作示意，要求患者示齿或扬眉和闭眼。对反应差或不能理解的患者，根据伤害性刺激时表情的对称性评分。有面部创伤/绷带、经口气管插管、胶带或其他物理障碍影响面部检查时，应尽可能移开。</li>
    			<s:radio list="#{'选择答案为0':'正常对称运动<br />','选择答案为1':'轻微瘫痪（鼻唇沟变平，微笑时不对称）。<br />','选择答案为2':'部分瘫痪（下面部完全或几乎完全瘫痪）。<br />','选择答案为3':'一侧或双侧完全瘫痪（上下面部运动消失）。<br />'}" name="question6" ></s:radio>
    		
    		<li>上肢运动：将肢体置于合适的位置： 伸臂（掌心向下）90o（坐位）或 45o（仰卧）。根据上肢是否在 10 秒内落下，给漂移评分。对失语者用声音或手势引导，不用伤害性刺激。依次检查每个肢体，从非瘫痪侧上肢开始。只有在截肢或肩关节融和时，才记为无法测（UN），要写明原因。</li>
    			<s:radio list="#{'选择答案为0':'无漂移；肢体置于 90o （或 45o ）能坚持10 秒<br />','选择答案为1':'漂移；肢体置于 90o （或 45o ），但不到10 秒即向下漂移；不碰到床或其他支持物。<br />','选择答案为2':'部分抵抗重力； 肢体不能伸到或维持在 （引导下 90o （或 45o ），向下漂移到床，但能部分抵抗重力。<br />','选择答案为3':'不能抵抗重力；肢体落下<br />','选择答案为4':'无运动<br />'}" name="question7" ></s:radio>
    		
    		<li>下肢运动：将肢体置于合适的位置： 抬腿 30o（一定是仰卧位）。根据下肢是否在 5 秒内落下，给漂移评分。对失语者用声音或手势引导，不用伤害性刺激。依次检查每个肢体，从非瘫痪侧下肢开始。只有在截肢或髋关节融和时， 才记为无法测 （UN），要写明原因。</li>
    			<s:radio list="#{'选择答案为0':'无漂移；下肢置于 30o 能坚持 5 秒。<br />','选择答案为1':' 漂移；下肢在接近 5 秒时落下，但不碰到床<br />','选择答案为2':'部分抵抗重力；下肢在 5 秒内落到床上，但能部分抵抗重力。<br />','选择答案为3':'不能抵抗重力；下肢立即落到床上。<br />','选择答案为4':'无运动<br />'}" name="question8" ></s:radio>
    		
    		<li>肢体共济失调：目的是发现单侧小脑病变的证据。检查时睁眼。若有视力缺陷，应确保检查在未受损的视野中进行。进行双侧指鼻试验和跟膝胫试验。共济失调与无力明显不成比例时记分。若患者不能理解或肢体瘫痪，记为 0 分。只有在截肢或关节融和时，才记为无法测（UN），要写明原因。盲人用伸展的上肢摸鼻。</li>
    			<s:radio list="#{'选择答案为0':'无共济失调。<br />','选择答案为1':'一个肢体有。<br />','选择答案为2':'两个肢体有。<br />'}" name="question9" ></s:radio>
    		
    		<li>感觉：</li>
    			<s:radio list="#{'选择答案为0':'正常；无感觉缺失<br />','选择答案为1':'轻到中度感觉缺失；患侧感觉针刺不尖锐或钝； 或针刺的表浅疼痛感缺失但有触觉。<br />','选择答案为2':'重度到完全感觉缺失；面、上肢、下肢触觉丧失。<br />'}" name="question10" ></s:radio>
    		
    		<li>最佳语言：</li>
    			<s:radio list="#{'选择答案为0':'无失语；正常<br />','选择答案为1':'轻到中度失语；流利性或理解能力有一定程度的下降，但表达形式及思想的表达无明显受限。然而，言语和/或理解的减少使关于所提供材料的会话困难或不能进行。例如，在提供材料会话中，检查者可以从例如，在提供材料会话中，检查者可以从患者的反应中识别图片或命名卡片的内容<br />','选择答案为2':'重度失语；所有交流是通过破碎的语言表达；听者需很多推理、询问、猜测。信息交流的范围受限；听者感觉交流困难。检查者不能识别患者反应中提供的材料','选择答案为3':'不能说话或者完全失语，无言语或听理解能力。'}" name="question11" ></s:radio>
    			
    		
    		<li>构音障碍：如果患者被认为是正常的，必须通过让患者读或重复附表上的单词。若有严重的失语，根据自发语言中发音的清晰度评分。只有当气管插管或其他物理障碍不能讲话时， 才记为无法测 （UN），要写明原因。不要告诉患者为什么做测试。</li>
    			<s:radio list="#{'选择答案为0':'正常。<br />','选择答案为1':'轻到中度；患者至少能含糊地念一些词，并且虽稍有困难但至少能被理解。<br />','选择答案为2':'重度构音障碍；患者言语含糊以致无法理解，但无失语或与失语不成比例，或失音。<br />'}" name="question12" ></s:radio>
    		
    		<li>消退和不注意（以前为忽视）：在上述检查中已经充分获取了关于忽视的信息。若患者有严重视觉缺失以致无法进行视觉双侧同时刺激，并且皮肤刺激正常，记为正常。若失语，但确实注意到双侧，记分正常。视空间忽视或疾病失认也可被做为异常的证据。因为只有表现异常时才记录异常，所以此项一定是可测的。</li>	
    			<s:radio list="#{'选择答案为0':'无异常。<br />','选择答案为1':'视觉、触觉、听觉、空间觉或自身的不注意或者双侧同步刺激时一种感觉形式的消退。<br />','选择答案为2':' 严重的偏侧不注意或一种以上感觉形式的消退；不认识自己的手或只对一侧空间有定向力。<br />'}" name="question13" ></s:radio>
    		</ol>	
    		
    		<input id="submit" class="button" type="submit" value="提交"  />
			<input id="reset" class="button" type="reset" value="重置" />
 		
    	</form>
    </div>
     
    <div class="foot"> 友情链接：<a href="http://www.baidu.com" >百度</a> </div>
  </body>
</html>
