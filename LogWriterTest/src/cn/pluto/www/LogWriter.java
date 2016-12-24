package cn.pluto.www;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class LogWriter {
    private Document document = null;
    private String filepath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "log.xml";
    private Element root = null;
    private Element currentElement = null;
	
	public LogWriter(){
		try{
			SAXReader reader = new SAXReader();  
			document = reader.read(new File(filepath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		root = document.getRootElement();
		currentElement = root.addElement("action"); 
	}
	
	public void log(String tagName, String value, boolean isEnd){
		currentElement.addElement(tagName).addText(value); 
		if (isEnd){
			try { 
				OutputFormat format = OutputFormat.createPrettyPrint(); 
				format.setEncoding("gbk");
				Writer out = new FileWriter(filepath);
				XMLWriter writer = new XMLWriter(out, format); 
				writer.write(document); 
				writer.close(); 
				System.out.print("生成XML文件成功"); 
			} catch (Exception e) { 
				 System.out.print("生成XML文件失败"); 
				 e.printStackTrace(); 
			}
		}
	}
	
}
