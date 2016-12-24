package cn.pluto.www;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriterTest {

	public static void main(String[] args) {
		LogWriter lw = new LogWriter();
		Date d = null;
		String dateNowStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		
		lw.log("name", "login", false);
        d = new Date();  
        dateNowStr = sdf.format(d);
        
		lw.log("s-time", dateNowStr, false);
        d = new Date();  
        dateNowStr = sdf.format(d);  
		lw.log("e-time", dateNowStr, false);
		lw.log("result", "success", true);
	}

}
