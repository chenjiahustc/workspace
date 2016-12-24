package cn.pluto.www.xml;

import java.util.ArrayList;
import java.util.List;

public class Action {
	private String name = null;
	private ActionClass ac = null;
	private InterceptorRef interref = null;
	private List<Result> results = null;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ActionClass getAc() {
		return ac;
	}
	
	public void setAc(ActionClass ac) {
		this.ac = ac;
	}
	
	public InterceptorRef getInterref() {
		return interref;
	}
	
	public void setInterref(InterceptorRef interref) {
		this.interref = interref;
	}
	
	public List<Result> getResults() {
		return results;
	}
	
	public void setResults(List<Result> results) {
		this.results = results;
	}
}
