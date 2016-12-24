/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/2/29 20:10:01                           */
/*==============================================================*/

drop table if exists answers;		/*参评人员的答卷信息*/
drop table if exists questions;
drop table if exists paper;
drop table if exists participant;
drop table if exists analyst;








/*==============================================================*/
/* Table: analyst                                               */
/*==============================================================*/
create table analyst
(
   name                 varchar(30) not null,
   mail                 varchar(50),
   phone                varchar(15) not null,
   work_place           varchar(100),
   account              varchar(100) not null,
   password             varchar(20) not null,
   primary key (account)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*==============================================================*/
/*  向analyst表中插入分析人员信息                               */
/*==============================================================*/
insert into analyst values ('Jack','Jack@gmail.com','12345678001','苏州市第一人民医院','Jack','000');
insert into analyst values ('Pual','Pual@gmail.com','12345678002','苏州市第一人民医院','Pual','000');
insert into analyst values ('Lucy','Lucy@gmail.com','12345678003','苏州市第一人民医院','Lucy','000');
insert into analyst values ('Alex','Alex@gmail.com','12345678004','苏州市第一人民医院','Alex','000');
insert into analyst values ('Tony','Tony@gmail.com','12345678005','苏州市第一人民医院','Tony','000');

/*==============================================================*/
/* Table: paper                                                 */
/*==============================================================*/
create table paper
(
   paper_id             varchar(10) not null,
   account              varchar(100),
   is_public            bool,
   creation_time        date,
   primary key (paper_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*==============================================================*/
/*  向paper表中插入问卷信息                                     */
/*==============================================================*/
insert into paper values ('1','Jack',1,'2015-10-1');
insert into paper values ('2','Jack',1,'2015-10-2');
insert into paper values ('3','Pual',1,'2015-10-3');
insert into paper values ('4','Lucy',1,'2015-10-4');
insert into paper values ('5','Alex',1,'2015-10-5');
insert into paper values ('6','Tony',1,'2015-10-6');

/*==============================================================*/
/* Table: participant                                           */
/*==============================================================*/
create table participant
(
   name                 varchar(30) not null,
   sex                  varchar(4),
   phone                varchar(15) not null,
   mail                 varchar(50),
   work_place           varchar(100),
   work_number          varchar(20) not null,
   account              varchar(100),
   primary key (work_number)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*==============================================================*/
/*  向participant表中插入参评人员信息                           */
/*==============================================================*/
insert into participant values ('聪','男','12345670001','cong@qq.com','苏州市第一人民医院','su0001','Jack');
insert into participant values ('成','女','12345670002','cheng@qq.com','苏州市第一人民医院','su0002','Jack');
insert into participant values ('锐','男','12345670003','rui@qq.com','苏州市第一人民医院','su0003','Pual');
insert into participant values ('万','女','12345670004','wan@qq.com','苏州市第一人民医院','su0004','Alex');
insert into participant values ('杰','男','12345670005','jie@qq.com','苏州市第一人民医院','su0005','Tony');

/*==============================================================*/
/* Table: answers                                               */
/*==============================================================*/
create table answers
(
   answer_id			int not null,		/*答题编号*/
   work_number          varchar(20),		/*工号*/
   paper_id             varchar(10),		/*问卷号*/
   answer_time          date,				/*答题时间*/
   answer               varchar(100),		/*答案*/
   question_id          int ,				/*问题编号*/
   exam_id              int	,				/*考试编号*/
  primary key (answer_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: questions                                             */
/*==============================================================*/
create table questions
(
   paper_id             varchar(10),		/*问卷ID*/
   question_id          int,				/*问题编号*/
   question             varchar(200),		/*问题内容*/
   weight               bool				/*是否算分*/
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*==============================================================*/
/*  向questions表中插入问卷中问题的详细信息                     */
/*==============================================================*/
insert into questions values ('1',1,'姓名： ',0);
insert into questions values ('1',2,'职工编号： ',0);
insert into questions values ('1',3,'年龄： ',0);
insert into questions values ('1',4,'参加护理工作的时间： 年  月',0);
insert into questions values ('1',5,'性别: 男/女',0);
insert into questions values ('1',6,'婚姻状况：未婚/已婚/离异/丧偶',0);
insert into questions values ('1',7,'教育程度：初中及以下/高中/大专/本科/研究生及以上',0);
insert into questions values ('1',8,'所在科室：外科/内科/门诊/急诊/重症监护室/手术室',0);
insert into questions values ('1',9,'职龄：1-5年/6-10年/11-20年/21-30年/30年以上',0);
insert into questions values ('1',10,'职级：护士/护师/主管护师/副主任护师/主任护师/实习',0);
insert into questions values ('1',11,'工作时平均工作时间：8小时以下/8-10小时/10小时以上',0);
insert into questions values ('1',12,'每个月您平均上夜班的小时数是： ，每个月您平均休息的天数是：',0);
insert into questions values ('1',13,'工作让我感觉身心疲惫：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',14,'下班的时候我感觉精疲力竭：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',15,'晨起，不得不去面对一天的工作时，我感觉非常累：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',16,'整天工作对我来说确实压力很大：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',17,'工作让我快有要崩溃的感觉：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',18,'自从开始干这份工作，我对工作越来越不感兴趣：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',19,'我对工作不像以前那样热心了：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',20,'我怀疑自己所做的工作的意义：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',21,'我对自己所做的工作是否有贡献越来越不关心：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',22,'我能有效的解决我工作中出现的问题：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',23,'我觉得我在单位做有用的贡献：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',24,'在我看来，我擅长于自己的工作：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',25,'当完成工作上的一些事情时，我感到非常高兴：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',26,'我完成了很多有价值的工作：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',27,'我自信自己能有效地完成各项工作：从不/极少一年几次或者更少/偶尔一次或更少/经常一月几次/频繁每星期一次/非常频繁一星期几次/每天',1);
insert into questions values ('1',28,'总体来讲，您的健康状况是：非常好/很好/好/一般/差',1);
insert into questions values ('1',29,'和一年以前比，您觉得您现在的健康状况是：好多了/好一些/差不多/差一些/差多了',1);
insert into questions values ('1',30,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(1)重体力活，如跑步、举重等:限制很大/有些限制/毫无限制',1);
insert into questions values ('1',31,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(2)适度的活动：如扫地、打太极等:限制很大/有些限制/毫无限制',1);
insert into questions values ('1',32,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(3)手提日用品：如买菜、购物等:限制很大/有些限制/毫无限制',1);
insert into questions values ('1',33,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(4)上几层楼梯：限制很大/有些限制/毫无限制',1);
insert into questions values ('1',34,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(5)上一层楼梯：限制很大/有些限制/毫无限制',1);
insert into questions values ('1',35,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(6)弯腰、屈膝、下蹲：限制很大/有些限制/毫无限制',1);
insert into questions values ('1',36,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(7)步行1500m以上的路程：限制很大/有些限制/毫无限制',1);
insert into questions values ('1',37,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(8)步行1000m以上的路程：限制很大/有些限制/毫无限制',1);
insert into questions values ('1',38,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(9)步行100m以上的路程：限制很大/有些限制/毫无限制',1);
insert into questions values ('1',39,'您的健康状况是否限制了这些活动？如果有限制，程度如何？(10)自己洗澡、穿衣：限制很大/有些限制/毫无限制',1);
insert into questions values ('1',40,'在过去的4个星期里，您的工作和日常活动有无因为身体健康的原因而出现以下的这些问题？(1)减少了工作或其他活动时间：是/不是',1);
insert into questions values ('1',41,'在过去的4个星期里，您的工作和日常活动有无因为身体健康的原因而出现以下的这些问题？(2)本来想要做的事情只能完成一部分：是/不是',1);
insert into questions values ('1',42,'在过去的4个星期里，您的工作和日常活动有无因为身体健康的原因而出现以下的这些问题？(3)想要干的工作和活动种类受到限制：是/不是',1);
insert into questions values ('1',43,'在过去的4个星期里，您的工作和日常活动有无因为身体健康的原因而出现以下的这些问题？(4)减少了工作或其他活动时间：是/不是',1);
insert into questions values ('1',44,'在过去的4个星期里，您的工作和日常生活有无因情绪的原因（如压抑或忧虑)而出现以下问题？(1)减少了工作或其他活动时间：是/不是',1);
insert into questions values ('1',45,'在过去的4个星期里，您的工作和日常生活有无因情绪的原因（如压抑或忧虑)而出现以下问题？(2)本来想要做的事情只能完成一部分：是/不是',1);
insert into questions values ('1',46,'在过去的4个星期里，您的工作和日常生活有无因情绪的原因（如压抑或忧虑)而出现以下问题？(3)干事情不如平时仔细：是/不是',1);
insert into questions values ('1',47,'在过去的4个星期里，在过去的4个星期里，您的健康或情绪不好在多大程度影响了您与家人、朋友、邻居或集体的正常社会交往？：完全没有影响/有一点影响/中等影响/影响很大/影响非常大',1);
insert into questions values ('1',48,'在过去的4个星期里，您有身体疼痛吗？：完全没有/稍微有点/有一点/中等/严重/很严重',1);
insert into questions values ('1',49,'在过去的4个星期里，在过去的4个星期里，身体疼痛影响您的工作和家务吗？：完全没有影响/有一点影响/中等影响/影响很大/影响非常大',1);
insert into questions values ('1',50,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(1)您觉得生活充实：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',51,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(2)您是一个敏感的人：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',52,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(3)您的情绪非常不好，什么事情都不能是您高兴：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',53,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(4)您的心理很平静：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',54,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(5)您做事情精力充沛：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',55,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(6)您的情绪低落：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',56,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(7)您觉得精疲力尽：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',57,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(8)您是一个快乐的人：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',58,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(9)您感觉厌烦：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',59,'以下这些问题有关过去1个月里您自己的感觉，对每一条问题所说的事情，您的情况是什么样的？(10)不健康影响了您的社会活动：所有时间/大部分时间/比较多时间/一部分时间/小部分时间/没这种感觉',1);
insert into questions values ('1',60,'请看下列每一条问题，哪一种答案最符合您的情况(1)我好像比别人容易生病：绝对正确/大部分正确/不能肯定/大部分错误/绝对错误',1);
insert into questions values ('1',61,'请看下列每一条问题，哪一种答案最符合您的情况(2)我跟周围人一样健康：绝对正确/大部分正确/不能肯定/大部分错误/绝对错误',1);
insert into questions values ('1',62,'请看下列每一条问题，哪一种答案最符合您的情况(3)我认为我的健康状况在变坏：绝对正确/大部分正确/不能肯定/大部分错误/绝对错误',1);
insert into questions values ('1',63,'请看下列每一条问题，哪一种答案最符合您的情况(4)我的健康状况非常好：绝对正确/大部分正确/不能肯定/大部分错误/绝对错误',1);

insert into questions values ('1',64,'继续深造的机会太少：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',65,'工资及其他福利待遇低：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',66,'晋升的机会太少：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',67,'经常倒班：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',68,'工作中的独立性少：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',69,'工作分工不明确：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',70,'工作量太大：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',71,'上班的护士数量少：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',72,'没有时间对病人实施心理护理：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',73,'非护理性的工作太多：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',74,'无用的书面工作太多：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',75,'工作环境差：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',76,'工作中所需的仪器设备不足：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',77,'病区拥挤：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',78,'担心工作中出现差错事故：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',79,'护士工作未被病人及家属承认：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',80,'护理的病人病情过重：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',81,'病人的家属不礼貌：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',82,'病人的要求太高或太过分：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',83,'病人不礼貌：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',84,'病人不合作：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',85,'所学的知识不能满足病人及家属的心理需要：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',86,'缺乏病人教育的相关知识：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',87,'担心护理操作会引起病人的疼痛：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',88,'护理的病人突然死亡：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',89,'缺乏其他卫生工作人员的理解及尊重：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',90,'护理管理者的理解与支持不够：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',91,'护理管理者的批评过多：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',92,'医生对护理answers工作过分挑剔：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',93,'同事之间缺乏理解与支持：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',94,'与护理管理者发生冲突：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',95,'与病区的某些护士工作很难：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',96,'与医生发生冲突：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',97,'同事之间缺乏又好合作的气氛：从未遇到/有时遇到/经常遇到/几乎每天遇到',1);
insert into questions values ('1',98,'科室有充足的支持设备让我有更多的时间护理患者：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',99,'科室的医生和护士工作关系融洽：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',100,'科室的管理者支持护理人员的工作：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',101,'医院对护士有积极的员工发展或继续教育计划：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',102,'我有职业发展或临床晋升的机会<：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',103,'护理人员有机会参与医院的管理决策：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',104,'护士paper犯错误时，领导更注重对其指导，而非一味的批评：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',105,'我有足够的机会和时间与科室的其他护士讨论患者的护理问题：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',106,'护士长是一位优秀的管理者和领导者：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',107,'护理部主任平易近人：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',108,'科室有充足的人员完成工作任务，如医生、护士、护理员等：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',109,'当我圆满完成工作时能获得鼓励和认可：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',110,'医院管理部门期望各病区为患者提供高标准的护理服务：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',111,'主管护理的领导与医院其他高层领导享有同样的权利和权威：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',112,'科室的护士和医生具有良好的团队合作精神：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',113,'我有进修学习的机会：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',114,'有明确的护理理念贯穿于科室的护理工作中：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',115,'我有机会与临床工作能力强的护士一同工作：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',116,'护士长支持科室护士做出的决定，即使与医生的相冲突：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',117,'管理部门会倾听和反馈护理人员的意见和建议：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',118,'医院有完善的护理质量监控程序：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',119,'护士能参与医院内部的管理：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',120,'科室的护士和医生经常密切配合协同工作：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',121,'医院对新进护士有指导培训计划：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',122,'医院的护理工作具有自己独特鲜明的护理模式：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',123,'护士有机会成为医院和护理委员会的一员：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',124,'护士长经常会与护士商讨日常的工作问题和程序：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',125,'我能及时书写患者的护理记录：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',126,'责任床的分配促进了护士对患者进行连续性的护理：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',127,'我在护理工作中经常使用护理诊断：完全不同意/不同意/同意/完全同意',1);
insert into questions values ('1',128,'通过工作学习或一些其他活动解脱：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',129,'与人交谈，倾诉内心烦恼：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',130,'尽量看到事物好的一面：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',131,'改变自己的想法，重新发现生活中什么重要：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',132,'不把问题看得太严重：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',133,'坚持自己的立场，为自己想得到的斗争：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',134,'找出几种不同的解决问题的方法：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',135,'向亲戚朋友或同学寻求建议：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',136,'改变原来的一些做法或自己的一些问题：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',137,'借鉴他人处理类似困难情景的办法：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',138,'寻求业余爱好，积极参加文体活动：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',139,'尽量克制自己的失望、悔恨、悲伤和愤怒：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',140,'试图休息或休假，暂时把问题（烦恼）抛开：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',141,'通过吸烟、喝酒、服药和吃东西来解除烦恼：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',142,'认为时间会改变现状，唯一要做的便是等待：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',143,'试图忘记整个事情：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',144,'依靠别人解决间题：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',145,'接受现实，因为没有其它办法：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',146,'幻想可能会发生某种奇迹改变现状：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',147,'自己安慰自己：不采取/偶尔采取/有时采取/经常采取',1);
insert into questions values ('1',148,'如果我尽力去做的话，我总是能够解决问题的：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',149,'即使别人反对我，我仍有办法取得我所要的：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',150,'对我来说，坚持理想和达成目标是轻而易举的：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',151,'我自信能有效地应付任何突如其来的事情：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',152,'以我的才智，我定能应付意料之外的情况：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',153,'如果我付出必要的努力，我一定能解决大多数的难题：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',154,'我能冷静地面对困难，因为我信赖自己处理问题的能力：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',155,'面对一个难题时，我通常能找到几个解决方法：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',156,'有麻烦的时候，我通常能想到一些应付的方法：完全不正确/有点正确/多数正确/完全正确',1);
insert into questions values ('1',157,'无论什么事在我身上发生，我都能应付自如：完全不正确/有点正确/多数正确/完全正确',1);

/*
新加部分问卷2、3、4
*/
insert into questions values ('2',1,'姓名：',0);
insert into questions values ('2',2,'工号：',0);
insert into questions values ('2',3,'电话：',0);
insert into questions values ('2',4,'年龄：',0);
insert into questions values ('2',5,'性别：',0);

insert into questions values ('2',6,'意识水平：即因气管插管、语言障碍、口腔气管创伤及绷带包扎等，不能全面评价，检查者也必须选择1个反应。只有在伤害性刺激不能引起患者任何活动时，才能记3分：清醒；反应灵敏/不清醒；轻微刺激能唤醒，可遵从命令、回答问题、做出反应/不清醒；需反复刺激才有注意，或者反应迟钝需要强烈或疼痛的刺激才有活动（非刻板的）/仅有反射性活动或植物效应或完全无反应、软瘫、无反射',1);
insert into questions values ('2',7,'意识水平提问：询问患者当前月份及其年龄。回答必须正确－不能按接近程度给予部分打分。不能理解问题的失语和昏睡者记 2 分。因气管插管、口腔气管创伤、任何原因引起的严重构音障碍、语言障碍或不是继发于失语的任何其他原因，导致不能言语，记 1 分。仅对最初回答评分。检查者不能给予其言语或非言语的提示：两个问题回答均正确/一个问题回答正确/两个问题回答均不正确',1);
insert into questions values ('2',8,'意识水平指令：先让患者睁眼和闭眼，再让患者非瘫痪侧握拳和伸掌。如果手不能使用，用另一种一步指令代替。有明确尝试但因为无力而不能完成的也算正确。若患者对指令无反应，检查者要给予演示（打手势），然后根据结果（如：遵从了 0 个、1个或 2 个指令）打分。有创伤、截肢或其他生理障碍者，应予适当的一步指令。仅对最初反应评分：两项任务执行均正确/一项任务执行正确/两项任务执行均不正确',1);
insert into questions values ('2',9,'最佳凝视：若患者的共轭性眼球偏斜能被随意或反射性活动克服，记 1 分。若为孤立的周围神经麻痹，记 1 分。有眼球创伤、早已失明或有其他视力或视野损害者，应当检查其反射性运动，这由检查者来决定。与患者的目光接触，然后从一侧向另一侧移动，偶尔能发现部分性凝视麻痹：正常/部分性凝视麻痹；单眼或双眼凝视异常，但无强迫偏斜或完全凝视麻痹/强迫偏斜，或不能被头眼反射克服的完全凝视麻痹',1);
insert into questions values ('2',10,'视野：若能正确地看向有手指活动的那一侧，记为正常。若单眼盲或眼球摘除，按剩余的那一只眼评分。如发现明确的不对称，包括象限盲，记 1 分。若全盲，无论什么原因导致，记 3 分。此时做双侧同时刺激，如果有视觉消退，记 1 分：无视野缺损/部分偏盲/完全偏盲/双侧偏盲（盲，包括皮质盲）',1);
insert into questions values ('2',11,'面瘫：言语指令或动作示意，要求患者示齿或扬眉和闭眼。对反应差或不能理解的患者，根据伤害性刺激时表情的对称性评分。有面部创伤/绷带、经口气管插管、胶带或其他物理障碍影响面部检查时，应尽可能移开：正常对称运动/轻微瘫痪（鼻唇沟变平，微笑时不对称）/部分瘫痪（下面部完全或几乎完全瘫痪）/一侧或双侧完全瘫痪（上下面部运动消失）',1);
insert into questions values ('2',12,'上肢运动：将肢体置于合适的位置： 伸臂90度或45度（仰卧）。根据上肢是否在10秒内落下，给漂移评分。从非瘫痪侧上肢开始。只有在截肢或肩关节融和时，才记为无法测（UN）：无漂移；肢体置于90度（或45度）能坚持10 秒/漂移；肢体置于90度（或45度），但不到10秒即向下漂移；不碰到其他支持物/部分抵抗重力：肢体不能伸到或维持在引导下90度（或45度），向下漂移到床/不能抵抗重力；肢体落下/无运动',1);
insert into questions values ('2',13,'下肢运动：将肢体置于合适的位置： 抬腿30度（一定是仰卧位）。根据下肢是否在 5 秒内落下，给漂移评分。对失语者用声音或手势引导。依次检查每个肢体，从非瘫痪侧下肢开始。只有在截肢或髋关节融和时， 才记为无法测 （UN）：无漂移；下肢置于30度能坚持 5 秒/漂移；下肢在接近 5 秒时落下，但不碰到床/部分抵抗重力；下肢在 5 秒内落到床上，但能部分抵抗重力/不能抵抗重力；下肢立即落到床上/无运动',1);
insert into questions values ('2',14,'肢体共济失调：目的是发现单侧小脑病变的证据。检查时睁眼。若有视力缺陷，应确保检查在未受损的视野中进行。进行双侧指鼻试验和跟膝胫试验。共济失调与无力明显不成比例时记分。若患者不能理解或肢体瘫痪，记为 0 分。只有在截肢或关节融和时，才记为无法测（UN），要写明原因。盲人用伸展的上肢摸鼻：无共济失调/一个肢体有/两个肢体有',1);
insert into questions values ('2',15,'感觉：正常；无感觉缺失/轻到中度感觉缺失；患侧感觉针刺不尖锐或钝； 或针刺的表浅疼痛感缺失但有触觉/重度到完全感觉缺失；面、上肢、下肢触觉丧失',1);
insert into questions values ('2',16,'最佳语言：无失语；正常/轻到中度失语；流利性或理解能力有一定程度的下降，但表达形式及思想的表达无明显受限。然而，言语和/或理解的减少使关于所提供材料的会话困难或不能进行/重度失语；所有交流是通过破碎的语言表达；听者需很多推理、询问、猜测。信息交流的范围受限；听者感觉交流困难。检查者不能识别患者反应中提供的材料/不能说话或者完全失语，无言语或听理解能力',1);
insert into questions values ('2',17,'构音障碍：如果患者被认为是正常的，必须通过让患者读或重复附表上的单词。若有严重的失语，根据自发语言中发音的清晰度评分。只有当气管插管或其他物理障碍不能讲话时， 才记为无法测 （UN），要写明原因。不要告诉患者为什么做测试：正常/轻到中度；患者至少能含糊地念一些词，并且虽稍有困难但至少能被理解/重度构音障碍；患者言语含糊以致无法理解，但无失语或与失语不成比例，或失音',1);
insert into questions values ('2',18,'消退和不注意（以前为忽视）：在上述检查中已经充分获取了关于忽视的信息。若患者有严重视觉缺失以致无法进行视觉双侧同时刺激，并且皮肤刺激正常，记为正常。若失语，但确实注意到双侧，记分正常。视空间忽视或疾病失认也可被做为异常的证据。因为只有表现异常时才记录异常：无异常/视觉、触觉、听觉、空间觉或自身的不注意或者双侧同步刺激时一种感觉形式的消退/严重的偏侧不注意或一种以上感觉形式的消退',1);


insert into questions values ('3',1,'姓名：',0);
insert into questions values ('3',2,'工号：',0);
insert into questions values ('3',3,'电话：',0);
insert into questions values ('3',4,'年龄：',0);
insert into questions values ('3',5,'性别：',0);
insert into questions values ('3',6,'首先请您选择最符合您一周所经历的平均痛苦水平的数字（10表示极度痛苦，1表示没有痛苦）：',1);
insert into questions values ('3',7,'请指出下列哪些选项是引起您痛苦的原因？(1)实际问题：无时间精力照顾孩子或老人/无时间精力做家务/经济问题/交通出行/工作和上学/周围环境',1);
insert into questions values ('3',8,'请指出下列哪些选项是引起您痛苦的原因？(2)身体问题：外表或形体/洗澡或穿衣/呼吸/排尿改变/便秘/腹泻/进食/疲乏/水肿/发烧/头晕/消化不良/口腔疼痛/恶心/鼻子干燥或充血/疼痛/性/皮肤干燥/手脚麻木/身体活动受限制',1);
insert into questions values ('3',9,'请指出下列哪些选项是引起您痛苦的原因？(3)交往问题：与老人和孩子相处/与伴侣相处/与亲友先出/与医护人员相处',1);
insert into questions values ('3',10,'请指出下列哪些选项是引起您痛苦的原因？(4)情绪问题：抑郁/恐惧/孤独/紧张/悲伤/担忧/对日常活动丧失兴趣/睡眠问题/记忆力下降/注意力不集中',1);
insert into questions values ('3',11,'请指出下列哪些选项是引起您痛苦的原因？(5)信仰/宗教问题：信仰或宗教问题',1);

insert into questions values ('4',1,'姓名：',0);
insert into questions values ('4',2,'工号：',0);
insert into questions values ('4',3,'电话：',0);
insert into questions values ('4',4,'年龄：',0);
insert into questions values ('4',5,'性别：',0);

insert into questions values ('4',6,'患者是否出现过一阵阵哭泣：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',7,'患者晚上是否烦躁不安、无法休息：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',8,'当你和患者说话时，他/她是否会避开你的目光：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',9,'患者是否会突然大哭不止：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',10,'患者是否有疼痛的表示：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',11,'患者是否容易生气：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',12,'患者是否拒绝与人交往：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',13,'患者是否显得烦躁和坐立不安：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',14,'患者是否呆坐不动：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);
insert into questions values ('4',15,'患者白天是否会找些事情做：最近1周每天都这样/最近1周4-6天是这样/最近1周1-4天是这样/最近1周从没有这样',1);

alter table answers add constraint FK_answers foreign key (work_number)
      references participant (work_number) on delete restrict on update restrict;

alter table answers add constraint FK_answers2 foreign key (paper_id)
      references paper (paper_id) on delete restrict on update restrict;
      
alter table paper add constraint FK_create foreign key (account)
      references analyst (account) on delete restrict on update restrict;

alter table participant add constraint FK_charge foreign key (account)
      references analyst (account) on delete restrict on update restrict;

alter table questions add constraint FK_Relationship_3 foreign key (paper_id)
      references paper (paper_id) on delete restrict on update restrict;


select * from questions where paper_id='4';