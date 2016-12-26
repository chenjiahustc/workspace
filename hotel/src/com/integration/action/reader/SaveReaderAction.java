package com.integration.action.reader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.integration.entity.Reader;
import com.integration.service.ReaderService;
@SuppressWarnings("serial")
public class SaveReaderAction extends ActionSupport {
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
		// 调用service相关的方法，完成实际的业务处理
		this.service.save(this.reader);
		return SUCCESS;
	}
	public String register() throws Exception {
		// 调用service相关的方法，完成实际的业务处理
		this.service.save(this.reader);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("reader", this.reader);
		return "regSuc";
	}
}