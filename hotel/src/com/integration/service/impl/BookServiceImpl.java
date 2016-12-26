package com.integration.service.impl;
import java.util.List;
import com.integration.entity.Book;
import com.integration.dao.BookDAO;
import com.integration.service.BookService;
public class BookServiceImpl implements BookService {
	private BookDAO bookDao;
	public BookDAO getBookDao() {
		return bookDao;
	}
	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}
	public List<Book> findAllBook() {
		return this.bookDao.findAllBook();
	}
	public Book findBookById(Integer id) {
		return this.bookDao.findBookById(id);
	}
	public void removeBook(Book book) {
		this.bookDao.removeBook(book);
	}
	public void saveBook(Book book) {
		this.bookDao.saveBook(book);
	}
	public void updateBook(Book book) {
		this.bookDao.updateBook(book);
	}
}
