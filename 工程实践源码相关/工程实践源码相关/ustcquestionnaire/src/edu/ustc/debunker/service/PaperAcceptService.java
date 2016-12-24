package edu.ustc.debunker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.ustc.debunker.dao.AnswersDao;
import edu.ustc.debunker.dao.ParticipantDao;
import edu.ustc.debunker.model.Answers;
import edu.ustc.debunker.model.Participant;

public class PaperAcceptService {
	public void PaperToDB(String work_number,String paper_id,Date answer_time,String exam_id,String[] answers){
		
		int question_id;
		Participant participant = new Participant();
		AnswersDao ad = new AnswersDao();
		ParticipantDao pd = new ParticipantDao();
		//此处需加work_number是否存在的判断机制
		if(pd.getParticipantByWorkNumber(work_number)==null){
			participant.setWork_number(work_number);
			participant.setName(answers[0]);
			participant.setPhone(answers[2]);
			participant.setSex(answers[4]);
			pd.setParticipant(participant);	
		}
		List<Answers> answerList = new ArrayList();
		for(question_id = 0;answers[question_id]!=null;question_id++)
		{ 
			Answers answer = new Answers();
			answer.setAnswer_time(answer_time);
			answer.setExam_id(exam_id);
			answer.setPaper_id(paper_id);
			answer.setWork_number(work_number);
			answer.setQuestion_id(question_id+1);
			answer.setAnswer(answers[question_id]);
			answerList.add(answer);
		}
		ad.setAnswers(answerList);
	}
	 
}
