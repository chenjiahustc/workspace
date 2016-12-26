package com.integration.action.reader;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.integration.service.ReaderService;
@SuppressWarnings("serial")
public class ListReaderAction extends ActionSupport {
	private ReaderService service;

	public ReaderService getService() {
		return service;
	}
	public void setService(ReaderService service) {
		this.service = service;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.service.findAll());
		return SUCCESS;
	}
}