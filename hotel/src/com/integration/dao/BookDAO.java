package com.integration.dao;
import java.util.List;
import com.integration.entity.Book;
public interface BookDAO {
	public void saveBook(Book book);
	public List<Book> findAllBook();		
	public void removeBook (Book book);	
	public void updateBook (Book book);	
	public Book findBookById(Integer id);	
}
