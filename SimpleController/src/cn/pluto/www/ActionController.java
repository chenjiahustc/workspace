package cn.pluto.www;

import java.io.File;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ActionController {
	private List<Action> actions = new ArrayList<>();
	private DocumentBuilderFactory builderFactory = null;
	private DocumentBuilder builder = null;
	private Document document = null;
	private Element rootElement = null;
	private NodeList nodes = null;
	
	public ActionController(String filepath){
		builderFactory = DocumentBuilderFactory.newInstance();
		
		try{
			builder = builderFactory.newDocumentBuilder();
			document = builder.parse(new File(filepath));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		rootElement = document.getDocumentElement();
		nodes = rootElement.getChildNodes();
		
		for (int i = 0;i < nodes.getLength();i++){
			Node node = nodes.item(i);
	        if(node.getNodeType() != Node.ELEMENT_NODE) {  
	            continue;  
	        }  
	        
			Action action = getAction(node);
			actions.add(action);
		}
	}
	
	public Action getAction(Node node){
		Action action = new Action();
		String name  = null;
		ActionClass ac = null;
		List<Result> results = new ArrayList<>();
		NodeList nodes = null;
		
		nodes = node.getChildNodes();
		
		for(int i = 0;i < nodes.getLength();i++){
			Node element = nodes.item(i);
			
	        if(element.getNodeType() != Node.ELEMENT_NODE) {  
	            continue;  
	        }  
	        
			if(element.getNodeName().trim().equals("name"))
				name = element.getTextContent().trim();
			else if (element.getNodeName().trim().equals("class"))
				ac = getActionClass(element);
			else if (element.getNodeName().trim().equals("result"))
				results.add(getResult(element));
			else
				;
		}
		
		action.setName(name);
		action.setAc(ac);
		action.setResults(results);
		
		return action;
	}
	
	public ActionClass getActionClass(Node node){
		NodeList nodes = node.getChildNodes();
		String name = null;
		String method = null;
		ActionClass ac = new ActionClass();
		
		for(int i = 0;i < nodes.getLength();i++){
			Node element = nodes.item(i);
			
	        if(element.getNodeType() != Node.ELEMENT_NODE) {  
	            continue;  
	        }  
	        
			if (element.getNodeName().trim().equals("name"))
				name = element.getTextContent().trim();
			else if (element.getNodeName().trim().equals("method"))
				method = element.getTextContent().trim();
			else
				;
		}
		
		ac.setName(name);
		ac.setMethod(method);
		
		return ac;
	}
	
	public Result getResult(Node node){
		NodeList nodes = node.getChildNodes();
		Result result = new Result();
		String name = null;
		String type = null;
		String value = null;
		
		for(int i = 0;i < nodes.getLength();i++)
		{
			Node element = nodes.item(i);

	        if(element.getNodeType() != Node.ELEMENT_NODE) {  
	            continue;  
	        }  
			if (element.getNodeName().trim().equals("name"))
				name = element.getTextContent().trim();
			else if (element.getNodeName().trim().equals("type"))
				type = element.getTextContent().trim();
			else if (element.getNodeName().trim().equals("value"))
				value = element.getTextContent().trim();
			else
				;
		}
		
		result.setName(name);
		result.setType(type);
		result.setValue(value);
		
		return result;
	}

	public boolean checkAction(String name){
		boolean result = false;
		
		for(Action action : actions){
			if (action.getName().equals(name))
				return true;
		}
		
		return false;
	}
	
	public String getActionClassName(String name){
		String classname = null;
		
		for(Action action : actions){
			if (action.getName().equals(name)){
				classname = action.getAc().getName();
			}
		}
		
		return classname;
	}

	public String getActionClassMethod(String name){
		String method = null;
		
		for(Action action : actions){
			if (action.getName().equals(name)){
				method = action.getAc().getMethod();
			}
		}
		
		return method;
	}
	
	public String getResultType(String actionname, String resultname){
		String type = null;
		
		for(Action action : actions){
			if (action.getName().equals(actionname)){
				for(Result result : action.getResults()){
					if(result.getName().equals(resultname)){
						type = result.getType();
					}
				}
			}
		}
		
		return type;
	}
	
	public String getResultValue(String actionname, String resultname){
		String value = null;
		
		for(Action action : actions){
			if (action.getName().equals(actionname)){
				for(Result result : action.getResults()){
					if(result.getName().equals(resultname)){
						value = result.getValue();
					}
				}
			}
		}
		
		return value;
	}
	
	
}

class Action{
	private String name = "";
	private ActionClass ac = null;
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
	
	public List<Result> getResults() {
		return results;
	}
	
	public void setResults(List<Result> results) {
		this.results = results;
	}
	
}

class ActionClass{
	private String name = null;
	private String method = null;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
}

class Result{
	private String name = null;
	private String type = null;
	private String value = null;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}