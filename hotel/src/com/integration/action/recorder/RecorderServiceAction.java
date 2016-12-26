package com.integration.action.recorder;
import java.util.ArrayList;
import java.util.List;
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
public class RecorderServiceAction extends ActionSupport {
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
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public RecorderService getRerderService() {
		return recorderService;
	}
	public void setRecorderService(RecorderService recorderService) {
		this.recorderService = recorderService;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	// �õ��û���Ԥ���ķ���
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		//�õ�orders�ĵ�ǰ�û��Ķ��� 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Reader reader = (Reader)session.getAttribute("reader");
		List<Recorder> recorders = this.recorderService.getReaderRecorder(reader);
		//�����û���order.getRoomid�õ��û������ķ������hotels
		List<Book> books = new ArrayList<Book>();
		if (recorders.size() > 0) {
			for (Recorder recorder : recorders) {
				books.add((Book)this.bookService.findBookById(recorder
						.getBookid()));
			}
		}
		//�����û������ķ���hotels��listUserHotel���棬��jsp����ȡ������ʾ 
		Map requestList = (Map) ActionContext.getContext().get("request");
		//requestList.put("listUserRoom", rooms);
		requestList.put("listReaderBook", books);
		return SUCCESS;
	}
	// �˶�
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//User user = (User) session.getAttribute("user");
		Reader reader = (Reader) session.getAttribute("reader");
		// ɾ������
		Recorder recorder = this.recorderService.findRecorderByReaderidAndBookid(reader
				.getReaderid(), book.getBookid());
		this.recorderService.removeRecorder(recorder);
		// ���÷���Ϊ�գ��޿���
		Book bookReader = this.bookService.findBookById(book.getBookid());
		bookReader .setStatus(0);
		this.bookService.updateBook(bookReader);
		message = "�˶�����ɹ���";
		return "delSuc";
	}
}