package com.integration.action.reader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.integration.entity.Reader;
import com.integration.service.ReaderService;
@SuppressWarnings("serial")
public class ReaderAction extends ActionSupport {
	private Reader reader;
	private ReaderService readerService;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public ReaderService getReaderService() {
		return readerService;
	}
	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}
	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
	public String login() throws Exception {
		Reader readerLogin = readerService.loginReader(reader);
		if (readerLogin != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("reader", readerLogin);
			return SUCCESS;
		}
		return INPUT;
	}
	public String loginOut() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("reader");
		return INPUT;
	}
	public String ReaderUpdateInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Reader reader = (Reader) session.getAttribute("reader");
		this.reader = this.readerService.findById(reader.getReaderid());
		return "readerUpdate";
	}
	public String updateReader() {
		this.readerService.update(reader);
		message = "修改信息成功。";
		return "updateSuc";
	}
}