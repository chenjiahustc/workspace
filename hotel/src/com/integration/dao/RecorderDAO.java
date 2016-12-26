package com.integration.dao;
import java.util.List;
import com.integration.entity.Recorder;
import com.integration.entity.Reader;
public interface RecorderDAO {
	public void saveRecorder(Recorder recorder);
	public List<Recorder> findAllRecorder();
	public void removeRecorder(Recorder recorder);
	public void updateRecorder(Recorder recorder);
	public Recorder findRecorderById(Integer id);
	public List<Recorder> getReaderRecorde(Reader reader);
	public Recorder findRecorderByReaderidAndBookid(int readerid, int bookid);
}
