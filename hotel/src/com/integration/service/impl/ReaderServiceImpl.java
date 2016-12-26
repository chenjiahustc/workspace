package com.integration.service.impl;
import java.util.List;
import com.integration.entity.Reader;
import com.integration.dao.ReaderDAO;
import com.integration.service.ReaderService;
public class ReaderServiceImpl implements ReaderService {
	private ReaderDAO readerDao;
	public ReaderDAO getReaderDao() {
		return readerDao;
	}
	public void setReaderDao(ReaderDAO readerDao) {
		this.readerDao = readerDao;
	}
	public void save(Reader reader) {
		this.readerDao.saveReader(reader); // 完成真正的业务逻辑
	}
	public List<Reader> findAll() {
		return this.readerDao.findAllReaders();
	}
	public void delete(Reader reader) {
		this.readerDao.removeReader(reader);
	}
	public void update(Reader reader) {
		this.readerDao.updateReader(reader);
	}
	public Reader findById(Integer id) {
		return this.readerDao.findReaderById(id);
	}
	public Reader loginReader(Reader reader) {
		return this.readerDao.loginReader(reader);
	}
}