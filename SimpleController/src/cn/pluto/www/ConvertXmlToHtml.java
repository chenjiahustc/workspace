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
		
		Element headElement = root.element("header");
		head = getHead(headElement);
		
		Element bodyElement = root.element("body");
		body = getBody(bodyElement);
		
		content = head + body;

		return content;
	}
	
	/***
	 * 将head节点装换为对应的html标记
	 * @param headElement
	 * @return 
	 */
	public String getHead(Element headElement){
		String head = null;
		
		head = "<head>";
		Element titleElement = headElement.element("title");
		head = head + getTitle(titleElement);
		head = head + "</head>";
		
		return head;
	}
	
	public String getTitle(Element titleElement){
		String title = null;
		
		title = "<title>";
		title = title + titleElement.getText();
		title = title + "</title>";
		
		return title;
	}
	
	public String getBody(Element bodyElement){
		String body = null;
		
		body = "<body>";
		Element elementForm = bodyElement.element("form");
		body = body + getForm(elementForm);
		body = body + "</body>";
		
		return body;
	}
	
	public String getForm(Element formElement){
		String form = null;
		
		form = "<form ";
		form = form + "name=" + "\""  + formElement.element("name").getText() + "\" ";
		form = form + "action=" + "\"" + formElement.element("action").getText() + "\" ";
		form = form + "post=" + "\"" + formElement.element("method").getText() + "\">";
		
		List<Element> textElements = formElement.elements("textView");
		for (Element element : textElements)
			form = form + getTextView(element) + "</br>";
		
		List<Element> buttonElements = formElement.elements("buttonView");
		for (Element element : buttonElements)
			form = form + getButtonView(element) + "</br>";
		
		form = form + "</form>";
		
		return form;
	}
	
	public String getTextView(Element textElement){
		String input = null;
		
		input = textElement.element("label").getText() + " : ";
		input = input + "<input type=\"text\" ";
		input = input + "name=" + "\"" + textElement.element("name").getText() + "\" ";
		input = input + "value=" + "\"" + textElement.element("value").getText() + "\"";
		input = input + "></input>";
		
		return input;
	}
	
	public String getButtonView(Element buttonElement){
		String input = null;
		
		input = buttonElement.element("label").getText() + " : ";
		input = input + "<input type=\"button\" ";
		input = input + "name=" + "\"" + buttonElement.element("name") + "\"";
		input = input + "></input>";
		
		return input;
	}
	
	
}
