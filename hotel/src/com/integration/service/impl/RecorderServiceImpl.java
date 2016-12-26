package com.integration.service.impl;
import java.util.List;
import com.integration.entity.Recorder;
import com.integration.entity.Reader;
import com.integration.dao.RecorderDAO;
import com.integration.service.RecorderService;
public class RecorderServiceImpl implements RecorderService {
	private RecorderDAO recorderDao;

	public RecorderDAO getRecorderDao() {
		return recorderDao;
	}
	public void setRecorderDao(RecorderDAO recorderDao) {
		this.recorderDao = recorderDao;
	}
	public List<Recorder> findAllRecorder() {
		return this.recorderDao.findAllRecorder();
	}
	public Recorder findRecorderById(Integer id) {
		return this.recorderDao.findRecorderById(id);
	}
	public void removeRecorder(Recorder recorder) {
		this.recorderDao.removeRecorder(recorder);
	}
	public void saveRecorder(Recorder recorder) {
		this.recorderDao.saveRecorder(recorder);
	}
	public void updateRecorder(Recorder recorder) {
		this.recorderDao.updateRecorder(recorder);
	}
	public List<Recorder> getReaderRecorder(Reader reader) {
		return this.recorderDao.getReaderRecorde(reader);
	}
	public Recorder findRecorderByReaderidAndBookid(int readerid, int bookid) {
		return this.recorderDao.findRecorderByReaderidAndBookid(readerid, bookid);
	}
}
