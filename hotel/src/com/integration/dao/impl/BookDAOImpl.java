package com.integration.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.integration.entity.Book;
import com.integration.dao.BookDAO;
public class BookDAOImpl extends HibernateDaoSupport implements BookDAO {
	@SuppressWarnings("unchecked")
	public List<Book> findAllBook() {
		String hql = "from Book book order by book.bookid desc";
		return (List<Book>) this.getHibernateTemplate().find(hql);
	}
	public Book findBookById(Integer id) {
		return (Book) this.getHibernateTemplate().get(Book.class, id);
	}
	public void removeBook(Book book) {
		this.getHibernateTemplate().delete(book);
	}
	public void saveBook(Book book) {
		this.getHibernateTemplate().save(book);
	}
	public void updateBook(Book book) {
		this.getHibernateTemplate().update(book);
	}
}
