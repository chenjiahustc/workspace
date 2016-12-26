package com.integration.service;
import java.util.List;
import com.integration.entity.Book;
public interface BookService {
	public void saveBook(Book book);
	public List<Book> findAllBook();			
	public void removeBook(Book book);
	public void updateBook(Book book);	
	public Book findBookById(Integer id);	
}
