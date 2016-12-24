package cn.pluto.www;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConvertXmlToHtml {
	private String filepath = null;
	private Document document = null;
	private Element root = null;
	
	public ConvertXmlToHtml(String filepath){
		this.filepath = filepath;
		
		try{
	        SAXReader reader = new SAXReader();  
	        document = reader.read(new File(filepath));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		root = document.getRootElement();
	}
	
	public String getHtml(){
		String content = null;
		String head = null;
		String body = null;
		


		return content;
	}
	
	/***
	 * 将head节点装换为对应的html标记
	 * @param headElement
	 * @return 
	 */
	public String getHead(Element headElement){
		String head = null;
		

		return head;
	}
	
	public String getTitle(Element titleElement){
		String title = null;

		return title;
	}
	
	public String getBody(Element bodyElement){
		String body = null;

		return body;
	}
	
	public String getForm(Element formElement){
		String form = null;
		

		
		return form;
	}
	
	public String getTextView(Element textElement){
		String input = null;
		
		
		return input;
	}
	
	public String getButtonView(Element buttonElement){
		String input = null;
		

		return input;
	}
	
	
}
