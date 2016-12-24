package cn.zq.www;

import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Xml_To_Html {

	 public static void Transform(String xmlFileName, String xslFileName,  
	            String htmlFileName) {  
	        try {  
	            TransformerFactory tFac = TransformerFactory.newInstance();  
	            Source xslSource = new StreamSource(xslFileName); 
	            Transformer t = tFac.newTransformer(xslSource);  
	            File xmlFile = new File(xmlFileName);  
	            File htmlFile = new File(htmlFileName);  
	            Source source = new StreamSource(xmlFile);  
	            Result result = new StreamResult(htmlFile);  
	            System.out.println(result.toString());  
	            t.transform(source, result);  
	        } catch (TransformerConfigurationException e) {  
	            e.printStackTrace();  
	        } catch (TransformerException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
	        String xmlFileName = "D:\\workspace\\xml_2_html\\success_view.xml";  
	        String xslFileName = "D:\\workspace\\xml_2_html\\success_view.xsl";  
	        String htmlFileName = "D:\\workspace\\xml_2_html\\success_view.html";  
	        Transform(xmlFileName, xslFileName, htmlFileName);  
	  
	    }  
	  
	}  
