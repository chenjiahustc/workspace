package com.integration.action.recorder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.integration.entity.Book;
import com.integration.entity.Recorder;
import com.integration.entity.Reader;
import com.integration.service.BookService;
import com.integration.service.RecorderService;
@SuppressWarnings("serial")
public class SaveRecorderAction extends ActionSupport {
	private Recorder recorder;
	private Reader reader;
	private Book book;
	private RecorderService recorderService;
	private BookService bookService;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public Recorder getRecorder() {
		return recorder;
	}
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	public RecorderService getRecorderService() {
		return recorderService;
	}
	public void setRecorderService(RecorderService recorderService) {
		this.recorderService = recorderService;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("listBook", this.bookService.findAllBook());
		return SUCCESS;
	}
	public String add() {
		Book bookReader = this.bookService.findBookById(book.getBookid());
		if (bookReader.getStatus() == 0) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			//User user = (User) session.getAttribute("user");
			Reader reader = (Reader)session.getAttribute("reader");
			recorder.setReaderid(reader.getReaderid());
			// Ԥ��
			System.out.println("readerid = " + recorder.getReaderid() + " bookid = " + recorder.getBookid());
			this.recorderService.saveRecorder(recorder);
			// ���÷���Ϊ�����п��ˣ�
			bookReader.setStatus(1);
			this.bookService.updateBook(bookReader);
			
			return "addSuc";
		} else {
			message = "�÷����Ѿ��п�����ס�ˡ�";
			return "addFail";
		}
	}
}