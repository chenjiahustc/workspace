package cn.pluto.www.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ActionController {
	private List<Interceptor> interceptors = null;
	private List<Action> actions = null;
	private Document document = null;

	
	
	public ActionController(String filepath){
		interceptors = new ArrayList<>();
		actions = new ArrayList<>();
		
		
		try{
	        SAXReader reader = new SAXReader();  
	        document = reader.read(new File(filepath));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Element root = document.getRootElement();
		
		List<Element> interceptorList = root.elements("interceptor");
		
		Interceptor interceptor = null;
		for(Element element : interceptorList){
			interceptor = getInterceptor(element);
			interceptors.add(interceptor);
		}
		
		List<Element> actionList = root.elements("action");
		
		Action action = null;
		for(Element element : actionList){
			action = getAction(element);
			actions.add(action);
		}
	}
	
	Interceptor getInterceptor(Element element){
		Interceptor interceptor = new Interceptor();
		String name = null;
		ActionClass ac = null;
		
		Element nameElement = element.element("name");
		name = nameElement.getText();
		
		Element classElement = element.element("class");
		ac = getActionClass(classElement);
		
		interceptor.setName(name);
		interceptor.setAc(ac);
		
		return interceptor;
	}
	
	Action getAction(Element element){
		Action action = new Action();
		String name = null;
		ActionClass ac = null;
		InterceptorRef ir = null;
		List<Result> results = new ArrayList<>();
		
		Element nameElement = element.element("name");
		name = nameElement.getText();
		
		Element classElement = element.element("class");
		ac = getActionClass(classElement);
		
		Element irElement = null;
		irElement = element.element("interceptor-ref");
		if (irElement != null)
			ir = getInterceptorRef(irElement);
		
		List<Element> resultElements = element.elements("result");
		Result result = null;
		for(Element resultElement : resultElements){
			result = getResult(resultElement);
			results.add(result);
		}
		
		action.setName(name);
		action.setAc(ac);
		if (ir != null)
			action.setInterref(ir);
		action.setResults(results);
		
		return action;
	}
	
	ActionClass getActionClass(Element element){
		ActionClass ac = new ActionClass();
		String name = null;
		String method = null;
	
		Element nameElement = element.element("name");
		name = nameElement.getText();
		
		Element methodElement = element.element("method");
		method = methodElement.getText();
		
		ac.setName(name);
		ac.setMethod(method);
	
		return ac;
	}
	
	InterceptorRef getInterceptorRef(Element element){
		InterceptorRef ir = new InterceptorRef();
		String name = null;
		
		Element nameElement = element.element("name");
		name = nameElement.getText();
		
		ir.setName(name);
		
		return ir;
	}
	
	Result getResult(Element element){
		Result result = new Result();
		String name = null;
		String type = null;
		String value = null;

		Element nameElement = element.element("name");
		name = nameElement.getText();
		
		Element typeElement = element.element("type");
		type = typeElement.getText();
		
		Element valueElement = element.element("value");
		value = valueElement.getText();
	
		result.setName(name);
		result.setType(type);
		result.setValue(value);
		
		return result;

	}
	
	public boolean checkAction(String name){
		for(Action action : actions){
			if (action.getName().equals(name))
				return true;
		}
		
		return false;
	}
	
	public boolean hasInterceptor(String name){	
		for(Action action : actions){
			if (action.getName().equals(name))
				if(action.getInterref() != null)
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
	
	public String getActionInterceptorRef(String name){
		String interceptorName = null;
		
		for(Action action : actions){
			if (action.getName().equals(name)){
				if(action.getInterref() != null)
					interceptorName = action.getInterref().getName();
			}
		}
		
		return interceptorName;
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
	
	public String getInterceptorClass(String name){
		String className = null;
		
		for(Interceptor ir : interceptors){
			if(ir.getName().equals(name)){
				className = ir.getAc().getName();
			}
		}
		
		return className;
	}
	
	public String getInterceptorClassMethod(String name){
		String classMethod = null;
		
		for(Interceptor ir : interceptors){
			if(ir.getName().equals(name)){
				classMethod = ir.getAc().getMethod();
			}
		}
		
		return classMethod;
	}
}
