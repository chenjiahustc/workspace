package com.integration.action.reader;
import com.opensymphony.xwork2.ActionSupport;
import com.integration.entity.Reader;
import com.integration.service.ReaderService;
@SuppressWarnings("serial")
public class UpdateReaderAction extends ActionSupport {
	private Reader reader;
	private ReaderService service;
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public ReaderService getService() {
		return service;
	}
	public void setService(ReaderService service) {
		this.service = service;
	}
	@Override
	public String execute() throws Exception {
		this.service.update(reader);
		return SUCCESS;
	}
}