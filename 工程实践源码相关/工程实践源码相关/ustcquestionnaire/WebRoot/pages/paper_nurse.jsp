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

<!--头部-->
<div class="head" >

  <h1>护士心理健康现状调查问卷</h1>
  <p><strong>亲爱的白衣天使：<br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;这份问卷旨在深入、真实的了解护士群体的工作压力及实际情况等，请您根据所在科室和您自身的情况回答，各项答案无所谓对错。您所填写的资料我们只做综合分析，并且严格为您保密。如果您愿意，我们会将分析结果返回给您。非常感谢您的参与!</strong></p>
</div>
<hr  color="#FFFFFF" />
<!--主体部分-->
<div class="main" id="questions">
  <form action="pnurseacceptaction" onsubmit="thank()" method="post" >
    <!-- required="required"--> 
    
    <!--第一部分，填写个人信息-->
    <div id="personal_information">
        <!--string name,work_number,sex,marriage,education,apartment,work_time,grade,average_work_time,question1-question51;
        integer age,work_year,work_month,night_work,rest_time;
-->    


	  <span>考场号：</span>
      <input id="exam_id" type="text" name="exam_id" required autofocus/>
      <h2>一、请根据您的个人情况，填写下列表格</h2>
     姓名：
      <input name="name" type="text" placeholder="eg：张三" required  />
      <br />
      <br />
      职工编号：
      <input name="work_number"  type="text" required/>
       <br />
      <br />
      电话：<input name="telphone" type="text" required />
      <br />
      <br />
      年龄：
      <input name="age" type="number" max="100" min="0"  value="20" required/>
      <br />
      <br />
      参加护理工作的时间：
      <input name="work_year" type="number" max="100" min="0"  value="1" required />
      年
      <input name="work_month" type="number" max="12" min="0"  value="0" required/>
      月 <br />
      <br />
      2、性别：&nbsp;
      <label  for="male">男</label>
      <input id="male" type="radio" name="sex"  value="男"/>
      &nbsp;
      <label  for="female">女</label>
      <input id="female" type="radio" name="sex" value="女" />
      <br />
      <br />
      3、婚姻状况：
      <select name="marriage">
        <option value="单身">单身</option>
        <option value="已婚">已婚</option>
        <option value="离异">离异</option>
        <option value="丧偶">丧偶</option>
      </select>
      <br />
      <br />
      4、教育程度：
      <select name="education">
        <option value="初中及以下">初中及以下</option>
        <option value="高中或者大专">高中或者大专</option>
        <option value="大专">大专</option>
        <option value="本科">本科</option>
        <option value="研究生及以上">研究生及以上</option>
      </select>
      <br />
      <br />
      <!-- 5、邮箱:
          <input name="email" type="email" id="mail" placeholder="例如：gc@163.com" required="required"/>
          <br />
          <br />
          6、电话：
          <input id="telphone" type="text" placeholder="选填"  />
          <br />--> 
      5、所在科室：
      <select name="apartment">
        <option value="内科">内科</option>
        <option value="外科">外科</option>
        <option value="门诊">门诊</option>
        <option value="急诊">急诊</option>
        <option value="重症监护室">重症监护室</option>
        <option value="手术室">手术室</option>
      </select>
      <br />
      <br />
      6、职龄：
      <select name="work_time">
        <option value="1-5年">1-5年</option>
        <option value="6-10年">6-10年</option>
        <option value="11-20年">11-20年</option>
        <option value="20-30年">20-30年</option>
        <option value="30年以上">30年以上</option>
      </select>
      <br />
      <br />
      7、职级：
      <select name="grade">
        <option value="护士">护士</option>
        <option value="护师">护师</option>
        <option value="主管护师">主管护师</option>
        <option value="副主任护师">副主任护师</option>
        <option value="主任护师">主任护师</option>
        <option value="实习">实习</option>
      </select>
      <br />
      <br />
      8、工作室平均工作时间：
      <select name="average_work_time">
        <option value="8小时以下">8小时以下</option>
        <option value="8-10小时">8-10小时</option>
        <option value="10小时以上">10小时以上</option>
      </select>
      <br />
      <br />
      9、每个月您平均上夜班的小时数是：
      <input name="night_work" type="number" max="1000" min="0"  value="20" required/>
      ,每个月您休息的天数是：
      <input name="rest_time" type="number" max="30" min="0"  value="8" required/>
      <br />
      <br />
      <button type="button" class="button" onclick="displayNext('personal_information','about_work','work')">下一页</button>
    </div>
    
    <!--关于工作方面的问题-->
    <div id="about_work" style="display:none">

      <h2>二、关于工作的调查问卷</h2>
      <ol>
        <li>工作让我感觉身心疲惫</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question1" ></s:radio>
       
        
        <li>下班的时候我感觉精疲力竭</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question2" ></s:radio>
        
        <li>晨起，不得不去面对一天的工作是，我感觉非常累</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question3" ></s:radio>
      
        <li>整天工作对我来说确实压力很大</li>
       	<s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question4" ></s:radio>
       
        <li>工作让我快有要崩溃的感觉</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question5" ></s:radio>
        
        <li>自从开始干这份工作，我对工作越来越不感兴趣</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question6" ></s:radio>
        
        <li>我对工作不像以前那样热心了</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question7" ></s:radio>
        
        <li>我怀疑自己所做的工作的意义</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question8" ></s:radio>
        
        <li>我对自己所做的工作是否有贡献越来越不关心</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question9" ></s:radio>
        
        <li>我能有效的解决我工作中出现的问题</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question10" ></s:radio>
        
        <li>我觉得我在单位做有用的贡献</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question11" ></s:radio>
        
        <li>在我看来，我擅长于自己的工作</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question12" ></s:radio>
        
        <li>当完成工作上的一些事情时，我感到非常高兴</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question13" ></s:radio>
        
        <li>我完成了很多有价值的工作</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question14" ></s:radio>
        
        <li>我自信自己能有效地完成各项工作</li>
        <s:radio list="#{'选择答案为1':'从不<br />','选择答案为2':'极少一年几次或者更少<br />','选择答案为3':'偶尔一次或更少<br />','选择答案为4':'经常一月几次<br />','选择答案为5':'频繁每星期一次<br />','选择答案为6':'非常频繁一星期几次<br />','选择答案为7':'每天<br />'}" name="question15" ></s:radio>
        
      </ol>
      <button type="button" class="button" onclick="displayNext('about_work','about_health','health')">下一页</button>
      <button type="button" class="button" onclick="displayBefore('about_work','personal_information','information')">上一页</button>
    </div>
    
    <!--关于健康方面的问题-->
    <div id="about_health" style="display:none">
      <h2>三、关于健康状况</h2>
      <ol>
        <li>总体来讲，您的健康状况是</li>
        <s:radio list="#{'选择答案为1':'非常好<br />','选择答案为2':'很好<br />','选择答案为3':'好<br />','选择答案为4':'一般<br />','选择答案为5':'差<br />'}" name="question16" ></s:radio>
        
        <li>和一年以前比，您觉得您现在的健康状况是</li>
        <s:radio list="#{'选择答案为1':'非常好<br />','选择答案为2':'很好<br />','选择答案为3':'好<br />','选择答案为4':'一般<br />','选择答案为5':'差<br />'}" name="question17" ></s:radio>
        
        
        <li>以下这些问题都和日常活动有关。请您想一想，您的健康状况是否限制了这些活动？如果有限制，程度如何？</li>
        (1)重体力活：如跑步、举重等:<br />
        <s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question18" ></s:radio>
        
        (2)适度的活动：如扫地、打太极等:<br />
       	<s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question19" ></s:radio>
       
        (3)手提日用品：如买菜、购物等:<br />
        <s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question20" ></s:radio>
        
        (4）上几层楼梯:<br />
        <s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question21" ></s:radio>
        
        (5)上一层楼梯<br />
       	<s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question22" ></s:radio>
        
        (6)弯腰、屈膝、下蹲:<br />
      	 <s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question23" ></s:radio>
        
        (7)步行1500m以上的路程:<br />
      	 <s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question24" ></s:radio>
        
        (8)步行1000m以上的路程:<br />
        <s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question25" ></s:radio>
       
        (9)步行100m以上的路程:<br />
        <s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question26" ></s:radio>
        
        (10)自己洗澡、穿衣:<br />
        <s:radio list="#{'选择答案为1':'限制很大<br />','选择答案为2':'有些限制<br />','选择答案为3':'毫无限制<br />'}" name="question27" ></s:radio>
       
        <li>在过去的4个星期里，您的工作和日常活动有无因为身体健康的原因而出现以下的这些问题？</li>
        (1)减少了工作或其他活动时间:<br />
      	 <s:radio list="#{'选择答案为1':'是<br />','选择答案为2':'不是<br />'}" name="question28" ></s:radio>
        
        (2)本来想要做的事情只能完成一部分:<br />
        <s:radio list="#{'选择答案为1':'是<br />','选择答案为2':'不是<br />'}" name="question29" ></s:radio>
       
        (3)想要干的工作和活动种类受到限制:<br />
       	<s:radio list="#{'选择答案为1':'是<br />','选择答案为2':'不是<br />'}" name="question30" ></s:radio>
       
        (4)减少了工作或其他活动时间:<br />
       	<s:radio list="#{'选择答案为1':'是<br />','选择答案为2':'不是<br />'}" name="question31" ></s:radio>
       
        <li>在过去的4个星期里，您的工作和日常生活有无因情绪的原因（如压抑或忧虑)而出现以下问题？</li>
        (1)减少了工作或其他活动时间:<br />
        <s:radio list="#{'选择答案为1':'是<br />','选择答案为2':'不是<br />'}" name="question32" ></s:radio>
        
        (2)本来想要做的事情只能完成一部分:<br />
        <s:radio list="#{'选择答案为1':'是<br />','选择答案为2':'不是<br />'}" name="question33" ></s:radio>
        
        (3)干事情不如平时仔细:<br />
       	<s:radio list="#{'选择答案为1':'是<br />','选择答案为2':'不是<br />'}" name="question34" ></s:radio>
        
        <li>在过去的4个星期里，您的健康或情绪不好在多大程度影响了您与家人、朋友、邻居或集体的正常社会交往？</li>
        <s:radio list="#{'选择答案为1':'完全没有影响<br />','选择答案为2':'有一点影响<br />','选择答案为3':'中等影响<br />','选择答案为4':'影响很大<br />','选择答案为5':'影响非常大<br />'}" name="question35" ></s:radio>
        
        <li>在过去的4个星期里，您有身体疼痛吗？</li>
       	<s:radio list="#{'选择答案为1':'完全没有<br />','选择答案为2':'稍微有点<br />','选择答案为3':'有一点<br />','选择答案为4':'中等<br />','选择答案为5':'严重<br />','选择答案为6':'很严重<br />'}" name="question36" ></s:radio>
        
        <li>在过去的4个星期里，身体疼痛影响您的工作和家务吗？</li>
        <s:radio list="#{'选择答案为1':'完全没有影响<br />','选择答案为2':'有一点影响<br />','选择答案为3':'中等影响<br />','选择答案为4':'影响很大<br />','选择答案为5':'影响非常大<br />'}" name="question37" ></s:radio>
        
        <li>以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？</li>
        (1)您觉得生活充实<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question38" ></s:radio>
       
        (2)您是一个敏感的人<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question39" ></s:radio>

        (3)您的情绪非常不好，什么事情都不能是您高兴<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question40" ></s:radio>
        
        (4)您的心理很平静<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question41" ></s:radio>
        
        (5)您做事情精力充沛<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question42" ></s:radio>
        
        (6)您的情绪低落<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question43" ></s:radio>
        
        (7)您觉得精疲力尽<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question44" ></s:radio>
        
        (8)您是一个快乐的人<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question45" ></s:radio>
        
        (9)您感觉厌烦<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question46" ></s:radio>
       
        (10)不健康影响了您的社会活动<br />
        <s:radio list="#{'选择答案为1':'所有时间<br />','选择答案为2':'大部分时间<br />','选择答案为3':'比较多时间<br />','选择答案为4':'一部分时间<br />','选择答案为5':'小部分时间<br />','选择答案为6':'没这种感觉<br />'}" name="question47" ></s:radio>
       
        <li>请看下列每一条问题，哪一种答案最符合您的情况</li>
        (1)我好像比别人容易生病<br />
        <s:radio list="#{'选择答案为1':'绝对正确<br />','选择答案为2':'大部分正确<br />','选择答案为3':'不能肯定<br />','选择答案为4':'大部分错误<br />','选择答案为5':'绝对错误<br />','选择答案为6':'没这种感觉<br />'}" name="question48" ></s:radio>
        
       	(2)我跟周围人一样健康<br />
        <s:radio list="#{'选择答案为1':'绝对正确<br />','选择答案为2':'大部分正确<br />','选择答案为3':'不能肯定<br />','选择答案为4':'大部分错误<br />','选择答案为5':'绝对错误<br />','选择答案为6':'没这种感觉<br />'}" name="question49" ></s:radio>
        
        (3)我认为我的健康状况在变坏<br />
     	<s:radio list="#{'选择答案为1':'绝对正确<br />','选择答案为2':'大部分正确<br />','选择答案为3':'不能肯定<br />','选择答案为4':'大部分错误<br />','选择答案为5':'绝对错误<br />','选择答案为6':'没这种感觉<br />'}" name="question50" ></s:radio>
        
        (4)我的健康状况非常好<br />
       	<s:radio list="#{'选择答案为1':'绝对正确<br />','选择答案为2':'大部分正确<br />','选择答案为3':'不能肯定<br />','选择答案为4':'大部分错误<br />','选择答案为5':'绝对错误<br />','选择答案为6':'没这种感觉<br />'}" name="question51" ></s:radio>
    
      </ol>
      <br />
      <button type="button" class="button" onclick="displayBefore('about_health','about_work','health')">上一页</button>
      <button type="button" class="button" onclick="displayNext('about_health','about_pressure','pressure')">下一页</button>
      <br />
    </div>
    
    <!--护士工作压力源量表-->
    <div id="about_pressure" style="display:none">

      <h2>四、工作压力源量表</h2>
      <ol>
         <li>继续深造的机会太少</li>
       		 <s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question52" ></s:radio>
        
        <li>工资及其他福利待遇低</li>
       		<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question53" ></s:radio>
       
        <li>晋升的机会太少</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question54" ></s:radio>
        
      	<li>经常倒班</li>
    		<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question55" ></s:radio>
        
        <li>工作中的独立性少</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question56" ></s:radio>
        
       	<li>工作分工不明确</li>
       		<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question57" ></s:radio>
        
        <li>工作量太大</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question58" ></s:radio>
       
        <li>上班的护士数量少</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question59" ></s:radio>
        
        
        <li>没有时间对病人实施心理护理</li>
      		<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question60" ></s:radio>
      
        <li>非护理性的工作太多</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question61" ></s:radio>
       
        <li>无用的书面工作太多</li>
     		<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question62" ></s:radio>
     	
     	<li>工作环境差</li>
     		<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question63" ></s:radio>
     	
        <li>工作中所需的仪器设备不足</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question64" ></s:radio>
        
        <li>病区拥挤</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question65" ></s:radio>
        
        <li>担心工作中出现差错事故</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question66" ></s:radio>
        
        <li>护士工作未被病人及家属承认</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question67" ></s:radio>
        
        <li>护理的病人病情过重</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question68" ></s:radio>
        
        <li>病人的家属不礼貌</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question69" ></s:radio>
        
        <li>病人的要求太高或太过分</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question70" ></s:radio>
        
        <li>病人不礼貌</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question71" ></s:radio>
        
        <li>病人不合作</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question72" ></s:radio>
        
        <li>所学的知识不能满足病人及家属的心理需要</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question73" ></s:radio>
       
        <li>缺乏病人教育的相关知识</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question74" ></s:radio>
       
        <li>担心护理操作会引起病人的疼痛</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question75" ></s:radio>
       
        <li>护理的病人突然死亡</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question76" ></s:radio>
       
        <li>缺乏其他卫生工作人员的理解及尊重</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question77" ></s:radio>
       
        <li>护理管理者的理解与支持不够</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question78" ></s:radio>
      
        <li>护理管理者的批评过多</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question79" ></s:radio>
       
        <li>医生对护理工作过分挑剔</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question80" ></s:radio>
       
        <li>同时之间缺乏理解与支持</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question81" ></s:radio>
       
        <li>与护理管理者发生冲突</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question82" ></s:radio>
      
        <li>与病区的某些护士工作很难</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question83" ></s:radio>
       
        <li>与医生发生冲突</li>
        	<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question84" ></s:radio>
      
        <li>同事之间缺乏又好合作的气氛</li>
       		<s:radio list="#{'选择答案为1':'从未遇到<br />','选择答案为2':'有时遇到<br />','选择答案为3':'经常遇到<br />','选择答案为4':'几乎每天遇到<br />'}" name="question85" ></s:radio>
      
        
      </ol>
      <button type="button" class="button" onclick="displayNext('about_pressure','about_environment','environment')">下一页</button>
      <button type="button" class="button" onclick="displayBefore('about_pressure','about_health','health')">上一页</button>
    </div>
    
    
    
     <!--关于工作环境-->
    <div id="about_environment" style="display:none">

      <h2>五、关于工作环境</h2>
      <ol>
        <li>科室有充足的支持设备让我有更多的时间护理患者</li>
        	<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question86" ></s:radio>
        	
        <li>科室的医生和护士工作关系融洽</li>
        	<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question87" ></s:radio>
        
        <li>科室的管理者支持护理人员的工作。</li>
       		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question88" ></s:radio>
       
        <li>医院对护士有积极的员工发展或继续教育计划</li>
        	<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question89" ></s:radio>
        
      	<li>我有职业发展或临床晋升的机会</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question90" ></s:radio>
      	
      	<li>护理人员有机会参与医院的管理决策</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question91" ></s:radio>
      	
      	<li>护士犯错误时，领导更注重对其指导，而非一味的批评</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question92" ></s:radio>
      	
      	<li>我有足够的机会和时间与科室的其他护士讨论患者的护理问题</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question93" ></s:radio>
      	
      	<li>科室有足够的注册护士可为患者提供高质量的护理</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question94" ></s:radio>
      	
      	<li>护士长是一位优秀的管理者和领导者</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question95" ></s:radio>
      	
      	<li>护理部主任平易近人</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question96" ></s:radio>
      	
      	<li>科室有充足的人员完成工作任务，如医生、护士、护理员等</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question97" ></s:radio>
      	
      	<li>当我圆满完成工作时能获得鼓励和认可</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question98" ></s:radio>
      	
      	<li>医院管理部门期望各病区为患者提供高标准的护理服务</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question99" ></s:radio>
      	
      	<li>主管护理的领导与医院其他高层领导享有同样的权利和权威</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question100" ></s:radio>
      	
      	<li>科室的护士和医生具有良好的团队合作精神</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question101" ></s:radio>
      	
      	<li>我有进修学习的机会</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question102" ></s:radio>
      	
      	<li>有明确的护理理念贯穿于科室的护理工作中</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question103" ></s:radio>
      	
      	<li>我有机会与临床工作能力强的护士一同工作</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question104" ></s:radio>
      	
      	<li>护士长支持科室护士做出的决定，即使与医生的相冲突</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question105" ></s:radio>
      	
      	<li>管理部门会倾听和反馈护理人员的意见和建议</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question106" ></s:radio>
      	
      	<li>医院有完善的护理质量监控程序</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question107" ></s:radio>
      	
      	<li>护士能参与医院内部的管理</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question108" ></s:radio>
      	
      	<li>科室的护士和医生经常密切配合协同工作</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question109" ></s:radio>
      	
      	<li>医院对新进护士有指导培训计划</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question110" ></s:radio>
      	
      	<li>医院的护理工作具有自己独特鲜明的护理模式</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question111" ></s:radio>
      	
      	<li>护士有机会成为医院和护理委员会的一员</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question112" ></s:radio>
      	
      	<li>护士长经常会与护士商讨日常的工作问题和程序</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question113" ></s:radio>
      	
      	<li>我能及时书写患者的护理记录</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question114" ></s:radio>
      	
      	<li>责任床的分配促进了护士对患者进行连续性的护理</li>
      		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question115" ></s:radio>
      	
      	<li>我在护理工作中经常使用护理诊断</li>
       		<s:radio list="#{'选择答案为1':'完全不同意<br />','选择答案为2':'不同意<br />','选择答案为3':'同意<br />','选择答案为4':'完全同意<br />'}" name="question116" ></s:radio>
       
      </ol>
      <button type="button" class="button" onclick="displayNext('about_environment','about_react','react')">下一页</button>
      <button type="button" class="button" onclick="displayBefore('about_environment','about_pressure','pressure')">上一页</button>
    </div>
    
      <!--关于应对方式的问题-->
    <div id="about_react" style="display:none">

      <h2>六、关于应对方式的问题</h2>
      <ol>
        <li>通过工作学习或一些其他活动解脱</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question117" ></s:radio>
        
        <li>与人交谈，倾诉内心烦恼</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question118" ></s:radio>
        
        <li>尽量看到事物好的一面</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question119" ></s:radio>
        
        <li>改变自己的想法，重新发现生活中什么重要</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question120" ></s:radio>
        
        <li>不把问题看得太严重</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question121" ></s:radio>
        
        <li>坚持自己的立场，为自己想得到的斗争</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question122" ></s:radio>
        
        <li>找出几种不同的解决问题的方法</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question123" ></s:radio>
        
        <li>向亲戚朋友或同学寻求建议</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question124" ></s:radio>
        
        <li>改变原来的一些做法或自己的一些问题</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question125" ></s:radio>
        
        <li>借鉴他人处理类似困难情景的办法</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question126" ></s:radio>
        
        <li>寻求业余爱好，积极参加文体活动</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question127" ></s:radio>
        
        <li>尽量克制自己的失望、悔恨、悲伤和愤怒</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question128" ></s:radio>
        
        <li>试图休息或休假，暂时把问题（烦恼）抛开</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question129" ></s:radio>
        
        <li>通过吸烟、喝酒、服药和吃东西来解除烦恼</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question130" ></s:radio>
        
        <li>认为时间会改变现状，唯一要做的便是等待</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question131" ></s:radio>
        
        <li>试图忘记整个事情</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question132" ></s:radio>
        
        <li>依靠别人解决间题</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question133" ></s:radio>
        
        <li>接受现实，因为没有其它办法</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question134" ></s:radio>
        
        <li>幻想可能会发生某种奇迹改变现状</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question135" ></s:radio>
        
        <li>自己安慰自己</li>
        	<s:radio list="#{'选择答案为1':'不采取<br />','选择答案为2':'偶尔采取<br />','选择答案为3':'有时采取<br />','选择答案为4':'经常采取<br />'}" name="question136" ></s:radio>
        
       
      </ol>
      <button type="button" class="button" onclick="displayNext('about_react','about_self','self')">下一页</button>
      <button type="button" class="button" onclick="displayBefore('about_react','about_environment','environment')">上一页</button>
    </div>
    
    
    
    
       <!--关于自我感受-->
    <div id="about_self" style="display:none">

      <h2>七、关于自我感受</h2>
      <ol>
        <li>如果我尽力去做的话，我总是能够解决问题的</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question137" ></s:radio>
        
        <li>即使别人反对我，我仍有办法取得我所要的</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question138" ></s:radio>
        
        <li>对我来说，坚持理想和达成目标是轻而易举的</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question139" ></s:radio>
        
        <li>我自信能有效地应付任何突如其来的事情</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question140" ></s:radio>
        
        <li>以我的才智，我定能应付意料之外的情况</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question141" ></s:radio>
        
        <li>如果我付出必要的努力，我一定能解决大多数的难题</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question142" ></s:radio>
        
        <li>我能冷静地面对困难，因为我信赖自己处理问题的能力</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question143" ></s:radio>
        
        <li>面对一个难题时，我通常能找到几个解决方法</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question144" ></s:radio>
        
        <li>有麻烦的时候，我通常能想到一些应付的方法</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question145" ></s:radio>
        
        <li>无论什么事在我身上发生，我都能应付自如</li>
        	<s:radio list="#{'选择答案为1':'完全不正确<br />','选择答案为2':'有点正确<br />','选择答案为3':'多数正确<br />','选择答案为4':'完全正确<br />'}" name="question146" ></s:radio>
        
       
      </ol>
      <button type="button" class="button" onclick="displayBefore('about_self','about_react','react')">上一页</button>
   <br />
    <br />
    <input id="submit" class="button" type="submit" value="提交"/>
    <input id="reset" class="button" type="reset" value="重置"  />
    </div>
  </form>
</div>

<!--底部-->
<div class="foot"> 友情链接：<a href="http://www.baidu.com" >百度</a> </div>
</body>
</html>