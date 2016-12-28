package com.integration.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.integration.entity.Reader;
import com.integration.dao.ReaderDAO;
public class ReaderDAOImpl extends HibernateDaoSupport implements ReaderDAO {
	public void saveReader(Reader reader) {
		this.getHibernateTemplate().save(reader);
	}
	@SuppressWarnings("unchecked")
	public List<Reader> findAllReaders() {
		String hql = "from Reader reader order by reader.readerid desc";
		return (List<Reader>) this.getHibernateTemplate().find(hql);
	}
	public void removeReader(Reader reader) {
		this.getHibernateTemplate().delete(reader);
	}
	public void updateReader(Reader reader) {
		this.getHibernateTemplate().update(reader);
	}
	public Reader findReaderById(Integer id) {
		Reader Reader = (Reader) this.getHibernateTemplate().get(Reader.class, id);

		return Reader;
	}
	@SuppressWarnings("unchecked")
	public Reader loginReader(Reader reader) {
		String hql = "from Reader reader where reader.username='"
				+ reader.getUsername() + "' and reader.password='"
				+ reader.getPassword() + "'";
		List<Reader> readers = (List<Reader>) this.getHibernateTemplate().find(hql);
		if (readers.size() > 0) {
			return readers.get(0);
		}
		return null;
	}
}
