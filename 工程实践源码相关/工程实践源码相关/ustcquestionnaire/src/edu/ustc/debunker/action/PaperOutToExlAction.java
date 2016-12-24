package edu.ustc.debunker.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.ustc.debunker.dao.AnalystDao;
import edu.ustc.debunker.dao.AnswersDao;
import edu.ustc.debunker.dao.PaperDao;
import edu.ustc.debunker.dao.QuestionsDao;
import edu.ustc.debunker.model.Analyst;
import edu.ustc.debunker.model.Answers;
import edu.ustc.debunker.model.Questions;
import edu.ustc.debunker.service.LoginService;
import edu.ustc.debunker.service.PaperToExlService;

public class PaperOutToExlAction extends ActionSupport {

	private String exam_id;
	private InputStream inputStream;
	public String getExam_id() {
		return exam_id;
	}

	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String download() throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		AnswersDao ad = new AnswersDao();
		QuestionsDao qd = new QuestionsDao();
		PaperDao pd = new PaperDao();
		String account = null;
		List<Answers> aall = ad.getAnswerByExamID(exam_id);
		Answers atest = aall.get(0);
		String paper_id = atest.getPaper_id();
		List<Questions> qall = qd.getAnswerByPaperID(paper_id);
		PaperToExlService pte = new PaperToExlService();
		try {
			pte.PaperToExl(qall, aall, exam_id, account, outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		outputStream.close();
		return SUCCESS;		
	}
	
}
