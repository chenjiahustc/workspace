package edu.ustc.debunker.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;

import edu.ustc.debunker.dao.AnswersDao;
import edu.ustc.debunker.model.Answers;
import edu.ustc.debunker.service.PaperAcceptService;

public class PaperAcceptAction extends ActionSupport {
	String exam_id,name,telphone,work_number,sex,marriage,education,apartment,work_time,grade,average_work_time;
	String question1,
	question2,
	question3,
	question4,
	question5,
	question6,
	question7,
	question8,
	question9,
	question10,
	question11,
	question12,
	question13,
	question14,
	question15,
	question16,
	question17,
	question18,
	question19,
	question20,
	question21,
	question22,
	question23,
	question24,
	question25,
	question26,
	question27,
	question28,
	question29,
	question30,
	question31,
	question32,
	question33,
	question34,
	question35,
	question36,
	question37,
	question38,
	question39,
	question40,
	question41,
	question42,
	question43,
	question44,
	question45,
	question46,
	question47,
	question48,
	question49,
	question50,
	question51,
	question52,
	question53,
	question54,
	question55,
	question56,
	question57,
	question58,
	question59,
	question60,
	question61,
	question62,
	question63,
	question64,
	question65,
	question66,
	question67,
	question68,
	question69,
	question70,
	question71,
	question72,
	question73,
	question74,
	question75,
	question76,
	question77,
	question78,
	question79,
	question80,
	question81,
	question82,
	question83,
	question84,
	question85,
	question86,
	question87,
	question88,
	question89,
	question90,
	question91,
	question92,
	question93,
	question94,
	question95,
	question96,
	question97,
	question98,
	question99,
	question100,
	question101,
	question102,
	question103,
	question104,
	question105,
	question106,
	question107,
	question108,
	question109,
	question110,
	question111,
	question112,
	question113,
	question114,
	question115,
	question116,
	question117,
	question118,
	question119,
	question120,
	question121,
	question122,
	question123,
	question124,
	question125,
	question126,
	question127,
	question128,
	question129,
	question130,
	question131,
	question132,
	question133,
	question134,
	question135,
	question136,
	question137,
	question138,
	question139,
	question140,
	question141,
	question142,
	question143,
	question144,
	question145,
	question146,
	question147,
	question148,
	question149,
	question150;
    Integer age,work_year,work_month,night_work,rest_time,painDegree;
    
	public Integer getAge() {
		return age;
	}
	
	public String getExam_id() {
		return exam_id;
	}

	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getWork_number() {
		return work_number;
	}

	public void setWork_number(String work_number) {
		this.work_number = work_number;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getWork_time() {
		return work_time;
	}

	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAverage_work_time() {
		return average_work_time;
	}

	public void setAverage_work_time(String average_work_time) {
		this.average_work_time = average_work_time;
	}

	public Integer getWork_year() {
		return work_year;
	}

	public void setWork_year(Integer work_year) {
		this.work_year = work_year;
	}

	public Integer getWork_month() {
		return work_month;
	}

	public void setWork_month(Integer work_month) {
		this.work_month = work_month;
	}

	public Integer getNight_work() {
		return night_work;
	}

	public void setNight_work(Integer night_work) {
		this.night_work = night_work;
	}

	public Integer getRest_time() {
		return rest_time;
	}

	public void setRest_time(Integer rest_time) {
		this.rest_time = rest_time;
	}
	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public String getQuestion5() {
		return question5;
	}

	public void setQuestion5(String question5) {
		this.question5 = question5;
	}

	public String getQuestion6() {
		return question6;
	}

	public void setQuestion6(String question6) {
		this.question6 = question6;
	}

	public String getQuestion7() {
		return question7;
	}

	public void setQuestion7(String question7) {
		this.question7 = question7;
	}

	public String getQuestion8() {
		return question8;
	}

	public void setQuestion8(String question8) {
		this.question8 = question8;
	}

	public String getQuestion9() {
		return question9;
	}

	public void setQuestion9(String question9) {
		this.question9 = question9;
	}

	public String getQuestion10() {
		return question10;
	}

	public void setQuestion10(String question10) {
		this.question10 = question10;
	}

	public String getQuestion11() {
		return question11;
	}

	public void setQuestion11(String question11) {
		this.question11 = question11;
	}

	public String getQuestion12() {
		return question12;
	}

	public void setQuestion12(String question12) {
		this.question12 = question12;
	}

	public String getQuestion13() {
		return question13;
	}

	public void setQuestion13(String question13) {
		this.question13 = question13;
	}

	public String getQuestion14() {
		return question14;
	}

	public void setQuestion14(String question14) {
		this.question14 = question14;
	}

	public String getQuestion15() {
		return question15;
	}

	public void setQuestion15(String question15) {
		this.question15 = question15;
	}

	public String getQuestion16() {
		return question16;
	}

	public void setQuestion16(String question16) {
		this.question16 = question16;
	}

	public String getQuestion17() {
		return question17;
	}

	public void setQuestion17(String question17) {
		this.question17 = question17;
	}

	public String getQuestion18() {
		return question18;
	}

	public void setQuestion18(String question18) {
		this.question18 = question18;
	}

	public String getQuestion19() {
		return question19;
	}

	public void setQuestion19(String question19) {
		this.question19 = question19;
	}

	public String getQuestion20() {
		return question20;
	}

	public void setQuestion20(String question20) {
		this.question20 = question20;
	}

	public String getQuestion21() {
		return question21;
	}

	public void setQuestion21(String question21) {
		this.question21 = question21;
	}

	public String getQuestion22() {
		return question22;
	}

	public void setQuestion22(String question22) {
		this.question22 = question22;
	}

	public String getQuestion23() {
		return question23;
	}

	public void setQuestion23(String question23) {
		this.question23 = question23;
	}

	public String getQuestion24() {
		return question24;
	}

	public void setQuestion24(String question24) {
		this.question24 = question24;
	}

	public String getQuestion25() {
		return question25;
	}

	public void setQuestion25(String question25) {
		this.question25 = question25;
	}

	public String getQuestion26() {
		return question26;
	}

	public void setQuestion26(String question26) {
		this.question26 = question26;
	}

	public String getQuestion27() {
		return question27;
	}

	public void setQuestion27(String question27) {
		this.question27 = question27;
	}

	public String getQuestion28() {
		return question28;
	}

	public void setQuestion28(String question28) {
		this.question28 = question28;
	}

	public String getQuestion29() {
		return question29;
	}

	public void setQuestion29(String question29) {
		this.question29 = question29;
	}

	public String getQuestion30() {
		return question30;
	}

	public void setQuestion30(String question30) {
		this.question30 = question30;
	}

	public String getQuestion31() {
		return question31;
	}

	public void setQuestion31(String question31) {
		this.question31 = question31;
	}

	public String getQuestion32() {
		return question32;
	}

	public void setQuestion32(String question32) {
		this.question32 = question32;
	}

	public String getQuestion33() {
		return question33;
	}

	public void setQuestion33(String question33) {
		this.question33 = question33;
	}

	public String getQuestion34() {
		return question34;
	}

	public void setQuestion34(String question34) {
		this.question34 = question34;
	}

	public String getQuestion35() {
		return question35;
	}

	public void setQuestion35(String question35) {
		this.question35 = question35;
	}

	public String getQuestion36() {
		return question36;
	}

	public void setQuestion36(String question36) {
		this.question36 = question36;
	}

	public String getQuestion37() {
		return question37;
	}

	public void setQuestion37(String question37) {
		this.question37 = question37;
	}

	public String getQuestion38() {
		return question38;
	}

	public void setQuestion38(String question38) {
		this.question38 = question38;
	}

	public String getQuestion39() {
		return question39;
	}

	public void setQuestion39(String question39) {
		this.question39 = question39;
	}

	public String getQuestion40() {
		return question40;
	}

	public void setQuestion40(String question40) {
		this.question40 = question40;
	}

	public String getQuestion41() {
		return question41;
	}

	public void setQuestion41(String question41) {
		this.question41 = question41;
	}

	public String getQuestion42() {
		return question42;
	}

	public void setQuestion42(String question42) {
		this.question42 = question42;
	}

	public String getQuestion43() {
		return question43;
	}

	public void setQuestion43(String question43) {
		this.question43 = question43;
	}

	public String getQuestion44() {
		return question44;
	}

	public void setQuestion44(String question44) {
		this.question44 = question44;
	}

	public String getQuestion45() {
		return question45;
	}

	public void setQuestion45(String question45) {
		this.question45 = question45;
	}

	public String getQuestion46() {
		return question46;
	}

	public void setQuestion46(String question46) {
		this.question46 = question46;
	}

	public String getQuestion47() {
		return question47;
	}

	public void setQuestion47(String question47) {
		this.question47 = question47;
	}

	public String getQuestion48() {
		return question48;
	}

	public void setQuestion48(String question48) {
		this.question48 = question48;
	}

	public String getQuestion49() {
		return question49;
	}

	public void setQuestion49(String question49) {
		this.question49 = question49;
	}

	public String getQuestion50() {
		return question50;
	}

	public void setQuestion50(String question50) {
		this.question50 = question50;
	}

	public String getQuestion51() {
		return question51;
	}

	public void setQuestion51(String question51) {
		this.question51 = question51;
	}

	public String painAccept(){
		String paper_id = "3";
		Date answer_time = new Date();
		java.sql.Date sqlDate=new java.sql.Date(answer_time.getTime());
		String[] answers = new String[20];
		answers[0] = name;
		answers[1] = work_number;
		answers[2] = telphone;
		answers[3] = age.toString();
		answers[4] = sex;
		answers[5] = painDegree.toString();
		answers[6] = question1;
		answers[7] = question2;
		answers[8] = question3;
		answers[9] = question4;
		answers[10] = question5;
		answers[11] = null;
		PaperAcceptService pas = new PaperAcceptService();
		pas.PaperToDB(work_number, paper_id, answer_time, exam_id, answers);
		//System.out.println("painaccept");
		return SUCCESS;
		
	}
	public String nihssAccept(){
		String paper_id = "2";
		Date answer_time = new Date();
		java.sql.Date sqlDate=new java.sql.Date(answer_time.getTime());
		String[] answers = new String[20];
		answers[0] = name;
		answers[1] = work_number;
		answers[2] = telphone;
		answers[3] = age.toString();
		answers[4] = sex;
		answers[5] = question1;
		answers[6] = question2;
		answers[7] = question3;
		answers[8] = question4;
		answers[9] = question5;
		answers[10] = question6;
		answers[11] = question7;
		answers[12] = question8;
		answers[13] = question9;
		answers[14] = question10;
		answers[15] = question11;
		answers[16] = question12;
		answers[17] = question13;
		answers[18] = null;	
		PaperAcceptService pas = new PaperAcceptService();
		pas.PaperToDB(work_number, paper_id, answer_time, exam_id, answers);
		//System.out.println("nihssAccept");
		return SUCCESS;
		
	}
	public String patientAccept(){
		String paper_id = "4";
		Date answer_time = new Date();
		java.sql.Date sqlDate=new java.sql.Date(answer_time.getTime());
		String[] answers = new String[20];
		answers[0] = name;
		answers[1] = work_number;
		answers[2] = telphone;
		answers[3] = age.toString();
		answers[4] = sex;
		answers[5] = question1;
		answers[6] = question2;
		answers[7] = question3;
		answers[8] = question4;
		answers[9] = question5;
		answers[10] = question6;
		answers[11] = question7;
		answers[12] = question8;
		answers[13] = question9;
		answers[14] = question10;
		answers[15] = null;		
		PaperAcceptService pas = new PaperAcceptService();
		pas.PaperToDB(work_number, paper_id, answer_time, exam_id, answers);
		return SUCCESS;
		
	}
	public String nurseAccept(){		
		//request.setCharacterEncoding("UTF-8");
		//String name = request.getParameter("name");
		String paper_id = "1";
		Date answer_time = new Date();
		String[] answers = new String[200];
		answers[0] = name;
		answers[1] = work_number;
		answers[2] = age.toString();
		answers[3] = work_year.toString()+","+work_month.toString();
		answers[4] = sex;
		answers[5] = marriage;
		answers[6] = education;
		answers[7] = apartment;
		answers[8] = work_time;
		answers[9] = grade;
		answers[10] = average_work_time;
		answers[11] = night_work.toString()+","+rest_time.toString();
		answers[12] = question1;
		answers[13] = question2;
		answers[14] = question3;
		answers[15] = question4;
		answers[16] = question5;
		answers[17] = question6;
		answers[18] = question7;
		answers[19] = question8;
		answers[20] = question9;
		answers[21] = question10;
		answers[22] = question11;
		answers[23] = question12;
		answers[24] = question13;
		answers[25] = question14;
		answers[26] = question15;
		answers[27] = question16;
		answers[28] = question17;
		answers[29] = question18;
		answers[30] = question19;
		answers[31] = question20;
		answers[32] = question21;
		answers[33] = question22;
		answers[34] = question23;
		answers[35] = question24;
		answers[36] = question25;
		answers[37] = question26;
		answers[38] = question27;
		answers[39] = question28;
		answers[40] = question29;
		answers[41] = question30;
		answers[42] = question31;
		answers[43] = question32;
		answers[44] = question33;
		answers[45] = question34;
		answers[46] = question35;
		answers[47] = question36;
		answers[48] = question37;
		answers[49] = question38;
		answers[50] = question39;
		answers[51] = question40;
		answers[52] = question41;
		answers[53] = question42;
		answers[54] = question43;
		answers[55] = question44;
		answers[56] = question45;
		answers[57] = question46;
		answers[58] = question47;
		answers[59] = question48;
		answers[60] = question49;
		answers[61] = question50;
		answers[62] = question51;
		answers[63] = question52;
		answers[64] = question53;
		answers[65] = question54;
		answers[66] = question55;
		answers[67] = question56;
		answers[68] = question57;
		answers[69] = question58;
		answers[70] = question59;
		answers[71] = question60;
		answers[72] = question61;
		answers[73] = question62;
		answers[74] = question63;
		answers[75] = question64;
		answers[76] = question65;
		answers[77] = question66;
		answers[78] = question67;
		answers[79] = question68;
		answers[80] = question69;
		answers[81] = question70;
		answers[82] = question71;
		answers[83] = question72;
		answers[84] = question73;
		answers[85] = question74;
		answers[86] = question75;
		answers[87] = question76;
		answers[88] = question77;
		answers[89] = question78;
		answers[90] = question79;
		answers[91] = question80;
		answers[92] = question81;
		answers[93] = question82;
		answers[94] = question83;
		answers[95] = question84;
		answers[96] = question85;
		answers[97] = question86;
		answers[98] = question87;
		answers[99] = question88;
		answers[100] = question89;
		answers[101] = question90;
		answers[102] = question91;
		answers[103] = question92;
		answers[104] = question93;
		answers[105] = question94;
		answers[106] = question95;
		answers[107] = question96;
		answers[108] = question97;
		answers[109] = question98;
		answers[110] = question99;
		answers[111] = question100;
		answers[112] = question101;
		answers[113] = question102;
		answers[114] = question103;
		answers[115] = question104;
		answers[116] = question105;
		answers[117] = question106;
		answers[118] = question107;
		answers[119] = question108;
		answers[120] = question109;
		answers[121] = question110;
		answers[122] = question111;
		answers[123] = question112;
		answers[124] = question113;
		answers[125] = question114;
		answers[126] = question115;
		answers[127] = question116;
		answers[128] = question117;
		answers[129] = question118;
		answers[130] = question119;
		answers[131] = question120;
		answers[132] = question121;
		answers[133] = question122;
		answers[134] = question123;
		answers[135] = question124;
		answers[136] = question125;
		answers[137] = question126;
		answers[138] = question127;
		answers[139] = question128;
		answers[140] = question129;
		answers[141] = question130;
		answers[142] = question131;
		answers[143] = question132;
		answers[144] = question133;
		answers[145] = question134;
		answers[146] = question135;
		answers[147] = question136;
		answers[148] = question137;
		answers[149] = question138;
		answers[150] = question139;
		answers[151] = question140;
		answers[152] = question141;
		answers[153] = question142;
		answers[154] = question143;
		answers[155] = question144;
		answers[156] = question145;
		answers[157] = question146;
		answers[158] = question147;
		answers[159] = null;
		PaperAcceptService pas = new PaperAcceptService();
		pas.PaperToDB(work_number, paper_id, answer_time, exam_id, answers);
		return "success";
	}

	public String getQuestion52() {
		return question52;
	}

	public void setQuestion52(String question52) {
		this.question52 = question52;
	}

	public String getQuestion53() {
		return question53;
	}

	public void setQuestion53(String question53) {
		this.question53 = question53;
	}

	public String getQuestion54() {
		return question54;
	}

	public void setQuestion54(String question54) {
		this.question54 = question54;
	}

	public String getQuestion55() {
		return question55;
	}

	public void setQuestion55(String question55) {
		this.question55 = question55;
	}

	public String getQuestion56() {
		return question56;
	}

	public void setQuestion56(String question56) {
		this.question56 = question56;
	}

	public String getQuestion57() {
		return question57;
	}

	public void setQuestion57(String question57) {
		this.question57 = question57;
	}

	public String getQuestion58() {
		return question58;
	}

	public void setQuestion58(String question58) {
		this.question58 = question58;
	}

	public String getQuestion59() {
		return question59;
	}

	public void setQuestion59(String question59) {
		this.question59 = question59;
	}

	public String getQuestion60() {
		return question60;
	}

	public void setQuestion60(String question60) {
		this.question60 = question60;
	}

	public String getQuestion61() {
		return question61;
	}

	public void setQuestion61(String question61) {
		this.question61 = question61;
	}

	public String getQuestion62() {
		return question62;
	}

	public void setQuestion62(String question62) {
		this.question62 = question62;
	}

	public String getQuestion63() {
		return question63;
	}

	public void setQuestion63(String question63) {
		this.question63 = question63;
	}

	public String getQuestion64() {
		return question64;
	}

	public void setQuestion64(String question64) {
		this.question64 = question64;
	}

	public String getQuestion65() {
		return question65;
	}

	public void setQuestion65(String question65) {
		this.question65 = question65;
	}

	public String getQuestion66() {
		return question66;
	}

	public void setQuestion66(String question66) {
		this.question66 = question66;
	}

	public String getQuestion67() {
		return question67;
	}

	public void setQuestion67(String question67) {
		this.question67 = question67;
	}

	public String getQuestion68() {
		return question68;
	}

	public void setQuestion68(String question68) {
		this.question68 = question68;
	}

	public String getQuestion69() {
		return question69;
	}

	public void setQuestion69(String question69) {
		this.question69 = question69;
	}

	public String getQuestion70() {
		return question70;
	}

	public void setQuestion70(String question70) {
		this.question70 = question70;
	}

	public String getQuestion71() {
		return question71;
	}

	public void setQuestion71(String question71) {
		this.question71 = question71;
	}

	public String getQuestion72() {
		return question72;
	}

	public void setQuestion72(String question72) {
		this.question72 = question72;
	}

	public String getQuestion73() {
		return question73;
	}

	public void setQuestion73(String question73) {
		this.question73 = question73;
	}

	public String getQuestion74() {
		return question74;
	}

	public void setQuestion74(String question74) {
		this.question74 = question74;
	}

	public String getQuestion75() {
		return question75;
	}

	public void setQuestion75(String question75) {
		this.question75 = question75;
	}

	public String getQuestion76() {
		return question76;
	}

	public void setQuestion76(String question76) {
		this.question76 = question76;
	}

	public String getQuestion77() {
		return question77;
	}

	public void setQuestion77(String question77) {
		this.question77 = question77;
	}

	public String getQuestion78() {
		return question78;
	}

	public void setQuestion78(String question78) {
		this.question78 = question78;
	}

	public String getQuestion79() {
		return question79;
	}

	public void setQuestion79(String question79) {
		this.question79 = question79;
	}

	public String getQuestion80() {
		return question80;
	}

	public void setQuestion80(String question80) {
		this.question80 = question80;
	}

	public String getQuestion81() {
		return question81;
	}

	public void setQuestion81(String question81) {
		this.question81 = question81;
	}

	public String getQuestion82() {
		return question82;
	}

	public void setQuestion82(String question82) {
		this.question82 = question82;
	}

	public String getQuestion83() {
		return question83;
	}

	public void setQuestion83(String question83) {
		this.question83 = question83;
	}

	public String getQuestion84() {
		return question84;
	}

	public void setQuestion84(String question84) {
		this.question84 = question84;
	}

	public String getQuestion85() {
		return question85;
	}

	public void setQuestion85(String question85) {
		this.question85 = question85;
	}

	public String getQuestion86() {
		return question86;
	}

	public void setQuestion86(String question86) {
		this.question86 = question86;
	}

	public String getQuestion87() {
		return question87;
	}

	public void setQuestion87(String question87) {
		this.question87 = question87;
	}

	public String getQuestion88() {
		return question88;
	}

	public void setQuestion88(String question88) {
		this.question88 = question88;
	}

	public String getQuestion89() {
		return question89;
	}

	public void setQuestion89(String question89) {
		this.question89 = question89;
	}

	public String getQuestion90() {
		return question90;
	}

	public void setQuestion90(String question90) {
		this.question90 = question90;
	}

	public String getQuestion91() {
		return question91;
	}

	public void setQuestion91(String question91) {
		this.question91 = question91;
	}

	public String getQuestion92() {
		return question92;
	}

	public void setQuestion92(String question92) {
		this.question92 = question92;
	}

	public String getQuestion93() {
		return question93;
	}

	public void setQuestion93(String question93) {
		this.question93 = question93;
	}

	public String getQuestion94() {
		return question94;
	}

	public void setQuestion94(String question94) {
		this.question94 = question94;
	}

	public String getQuestion95() {
		return question95;
	}

	public void setQuestion95(String question95) {
		this.question95 = question95;
	}

	public String getQuestion96() {
		return question96;
	}

	public void setQuestion96(String question96) {
		this.question96 = question96;
	}

	public String getQuestion97() {
		return question97;
	}

	public void setQuestion97(String question97) {
		this.question97 = question97;
	}

	public String getQuestion98() {
		return question98;
	}

	public void setQuestion98(String question98) {
		this.question98 = question98;
	}

	public String getQuestion99() {
		return question99;
	}

	public void setQuestion99(String question99) {
		this.question99 = question99;
	}

	public String getQuestion100() {
		return question100;
	}

	public void setQuestion100(String question100) {
		this.question100 = question100;
	}

	public String getQuestion101() {
		return question101;
	}

	public void setQuestion101(String question101) {
		this.question101 = question101;
	}

	public String getQuestion102() {
		return question102;
	}

	public void setQuestion102(String question102) {
		this.question102 = question102;
	}

	public String getQuestion103() {
		return question103;
	}

	public void setQuestion103(String question103) {
		this.question103 = question103;
	}

	public String getQuestion104() {
		return question104;
	}

	public void setQuestion104(String question104) {
		this.question104 = question104;
	}

	public String getQuestion105() {
		return question105;
	}

	public void setQuestion105(String question105) {
		this.question105 = question105;
	}

	public String getQuestion106() {
		return question106;
	}

	public void setQuestion106(String question106) {
		this.question106 = question106;
	}

	public String getQuestion107() {
		return question107;
	}

	public void setQuestion107(String question107) {
		this.question107 = question107;
	}

	public String getQuestion108() {
		return question108;
	}

	public void setQuestion108(String question108) {
		this.question108 = question108;
	}

	public String getQuestion109() {
		return question109;
	}

	public void setQuestion109(String question109) {
		this.question109 = question109;
	}

	public String getQuestion110() {
		return question110;
	}

	public void setQuestion110(String question110) {
		this.question110 = question110;
	}

	public String getQuestion111() {
		return question111;
	}

	public void setQuestion111(String question111) {
		this.question111 = question111;
	}

	public String getQuestion112() {
		return question112;
	}

	public void setQuestion112(String question112) {
		this.question112 = question112;
	}

	public String getQuestion113() {
		return question113;
	}

	public void setQuestion113(String question113) {
		this.question113 = question113;
	}

	public String getQuestion114() {
		return question114;
	}

	public void setQuestion114(String question114) {
		this.question114 = question114;
	}

	public String getQuestion115() {
		return question115;
	}

	public void setQuestion115(String question115) {
		this.question115 = question115;
	}

	public String getQuestion116() {
		return question116;
	}

	public void setQuestion116(String question116) {
		this.question116 = question116;
	}

	public String getQuestion117() {
		return question117;
	}

	public void setQuestion117(String question117) {
		this.question117 = question117;
	}

	public String getQuestion118() {
		return question118;
	}

	public void setQuestion118(String question118) {
		this.question118 = question118;
	}

	public String getQuestion119() {
		return question119;
	}

	public void setQuestion119(String question119) {
		this.question119 = question119;
	}

	public String getQuestion120() {
		return question120;
	}

	public void setQuestion120(String question120) {
		this.question120 = question120;
	}

	public String getQuestion121() {
		return question121;
	}

	public void setQuestion121(String question121) {
		this.question121 = question121;
	}

	public String getQuestion122() {
		return question122;
	}

	public void setQuestion122(String question122) {
		this.question122 = question122;
	}

	public String getQuestion123() {
		return question123;
	}

	public void setQuestion123(String question123) {
		this.question123 = question123;
	}

	public String getQuestion124() {
		return question124;
	}

	public void setQuestion124(String question124) {
		this.question124 = question124;
	}

	public String getQuestion125() {
		return question125;
	}

	public void setQuestion125(String question125) {
		this.question125 = question125;
	}

	public String getQuestion126() {
		return question126;
	}

	public void setQuestion126(String question126) {
		this.question126 = question126;
	}

	public String getQuestion127() {
		return question127;
	}

	public void setQuestion127(String question127) {
		this.question127 = question127;
	}

	public String getQuestion128() {
		return question128;
	}

	public void setQuestion128(String question128) {
		this.question128 = question128;
	}

	public String getQuestion129() {
		return question129;
	}

	public void setQuestion129(String question129) {
		this.question129 = question129;
	}

	public String getQuestion130() {
		return question130;
	}

	public void setQuestion130(String question130) {
		this.question130 = question130;
	}

	public String getQuestion131() {
		return question131;
	}

	public void setQuestion131(String question131) {
		this.question131 = question131;
	}

	public String getQuestion132() {
		return question132;
	}

	public void setQuestion132(String question132) {
		this.question132 = question132;
	}

	public String getQuestion133() {
		return question133;
	}

	public void setQuestion133(String question133) {
		this.question133 = question133;
	}

	public String getQuestion134() {
		return question134;
	}

	public void setQuestion134(String question134) {
		this.question134 = question134;
	}

	public String getQuestion135() {
		return question135;
	}

	public void setQuestion135(String question135) {
		this.question135 = question135;
	}

	public String getQuestion136() {
		return question136;
	}

	public void setQuestion136(String question136) {
		this.question136 = question136;
	}

	public String getQuestion137() {
		return question137;
	}

	public void setQuestion137(String question137) {
		this.question137 = question137;
	}

	public String getQuestion138() {
		return question138;
	}

	public void setQuestion138(String question138) {
		this.question138 = question138;
	}

	public String getQuestion139() {
		return question139;
	}

	public void setQuestion139(String question139) {
		this.question139 = question139;
	}

	public String getQuestion140() {
		return question140;
	}

	public void setQuestion140(String question140) {
		this.question140 = question140;
	}

	public String getQuestion141() {
		return question141;
	}

	public void setQuestion141(String question141) {
		this.question141 = question141;
	}

	public String getQuestion142() {
		return question142;
	}

	public void setQuestion142(String question142) {
		this.question142 = question142;
	}

	public String getQuestion143() {
		return question143;
	}

	public void setQuestion143(String question143) {
		this.question143 = question143;
	}

	public String getQuestion144() {
		return question144;
	}

	public void setQuestion144(String question144) {
		this.question144 = question144;
	}

	public String getQuestion145() {
		return question145;
	}

	public void setQuestion145(String question145) {
		this.question145 = question145;
	}

	public String getQuestion146() {
		return question146;
	}

	public void setQuestion146(String question146) {
		this.question146 = question146;
	}

	public String getQuestion147() {
		return question147;
	}

	public void setQuestion147(String question147) {
		this.question147 = question147;
	}

	public String getQuestion148() {
		return question148;
	}

	public void setQuestion148(String question148) {
		this.question148 = question148;
	}

	public String getQuestion149() {
		return question149;
	}

	public void setQuestion149(String question149) {
		this.question149 = question149;
	}

	public String getQuestion150() {
		return question150;
	}

	public void setQuestion150(String question150) {
		this.question150 = question150;
	}

	public Integer getPainDegree() {
		return painDegree;
	}

	public void setPainDegree(Integer painDegree) {
		this.painDegree = painDegree;
	}

	
	
	
}
