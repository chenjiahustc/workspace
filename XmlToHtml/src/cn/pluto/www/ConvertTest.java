package cn.pluto.www;

public class ConvertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String html = null;
		String filepath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "success_view.xml";
		
		ConvertXmlToHtml cxt = new ConvertXmlToHtml(filepath);
		html = cxt.getHtml();
		
		System.out.println(html);
	}

}
