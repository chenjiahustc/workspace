package com.integration.action.recorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.integration.entity.Book;
import com.integration.entity.Recorder;
import com.integration.service.BookService;
import com.integration.service.RecorderService;
@SuppressWarnings("serial")
public class ListRecorderAction extends ActionSupport {
	private Recorder recorder;
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
		//得到orders的所有用户的订单 
		List<Recorder> recorders = this.recorderService.findAllRecorder();
		//根据用户的order.getRoomid得到用户所定的房间存入hotels
		List<Book> books = new ArrayList<Book>();
		if (recorders.size() > 0) {
			for (Recorder recorder : recorders) {
				books.add((Book) this.bookService.findBookById(recorder
						.getBookid()));
			}
		}
		//保存用户所定的房间hotels到listAllHotel里面，在jsp里面取出来显示 
		Map requestList = (Map) ActionContext.getContext().get("request");
		requestList.put("listAllBook", books);
		return SUCCESS;
	}
}