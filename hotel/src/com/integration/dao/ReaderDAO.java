package com.integration.dao;
import java.util.List;
import com.integration.entity.Reader;
public interface ReaderDAO {
	public void saveReader(Reader reader);
	public List<Reader> findAllReaders();
	public void removeReader(Reader reader);
	public void updateReader(Reader reader);
	public Reader findReaderById(Integer id);
	public Reader loginReader(Reader reader);
}
