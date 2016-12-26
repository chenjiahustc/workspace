package com.integration.service;
import java.util.List;
import com.integration.entity.Reader;
public interface ReaderService {
	public void save(Reader reader);
	public List<Reader> findAll();
	public void delete(Reader reader);
	public void update(Reader reader);
	public Reader findById(Integer id);
	public Reader loginReader(Reader reader);
}
