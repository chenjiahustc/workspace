package com.integration.service;
import java.util.List;
import com.integration.entity.Recorder;
import com.integration.entity.Reader;
public interface RecorderService {
	public void saveRecorder(Recorder recorder);
	public List<Recorder> findAllRecorder();
	public void removeRecorder(Recorder recorder);
	public void updateRecorder(Recorder recorder);
	public Recorder findRecorderById(Integer id);
	public List<Recorder> getReaderRecorder(Reader reader);
	public Recorder findRecorderByReaderidAndBookid(int readerid, int bookid);
}
