package com.integration.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.integration.entity.Recorder;
import com.integration.entity.Reader;
import com.integration.dao.RecorderDAO;
public class RecorderDAOImpl extends HibernateDaoSupport implements RecorderDAO {
	@SuppressWarnings("unchecked")
	public List<Recorder> findAllRecorder(){
		String hql = "from Recorder record order by record.recorderid desc";
		return (List<Recorder>) this.getHibernateTemplate().find(hql);
	}
	public Recorder findRecorderById(Integer id) {
		return (Recorder) this.getHibernateTemplate().get(Recorder.class, id);
	}
	public void removeRecorder(Recorder recorder) {
		this.getHibernateTemplate().delete(recorder);
	}
	public void saveRecorder(Recorder recorder) {
		this.getHibernateTemplate().save(recorder);
	}
	public void updateRecorder(Recorder recorder) {
		this.getHibernateTemplate().update(recorder);
	}
	@SuppressWarnings("unchecked")
	public List<Recorder> getReaderRecorder(Reader reader) {
		String hql = "from Recorder record where record.readerid='" + reader.getReaderid()
				+ "'";
		return (List<Recorder>) this.getHibernateTemplate().find(hql);
	}
	@SuppressWarnings("unchecked")
	public Recorder findRecorderByReaderidAndBookid(int readerid, int bookid) {
		String hql = "from Recorder record where record.readerid=" + readerid
				+ " and record.bookid=" + bookid + "";
		List<Recorder> recorders = (List<Recorder>) this.getHibernateTemplate()
				.find(hql);
		return recorders == null ? null : recorders.get(0);
	}
}
