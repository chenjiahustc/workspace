package cn.pluto.www;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SqlHelper {
	private static String url = "";
	private static String driver = "";
	private static String username = "";
	private static String password = "";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	static Properties prop = null;
	static FileInputStream fis = null;

	static {
		try{
			prop = new Properties();
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			System.out.println(path);
			path = "D:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SimpleController/";
			//fis = new FileInputStream(path + "dbinfo.properties");
			fis = new FileInputStream("dbinfo.properties");
			prop.load(fis);
			url = prop.getProperty("url");
			System.out.println("url = " + url);
			driver = prop.getProperty("driver");
			System.out.println("driver = " + driver);
			username = prop.getProperty("username");
			System.out.println("username = " + username);
			password = prop.getProperty("password");
			System.out.println("password = " + password);
			
			Class.forName(driver);
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			if (fis != null){
				try{
					fis.close();
				} catch(Exception e){
					e.printStackTrace();
				}
				
				fis = null;
			}
		}
	}
	
	public static Connection getConnection(){
		try{
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(){
		if (rs != null){
			try{
				rs.close();
			} catch (Exception e){
				e.printStackTrace();
			}
			
			rs = null;
		}
		
		if (ps != null){
			try{
				ps.close();
			} catch(Exception e){
				e.printStackTrace();
			}
			
			ps = null;
		}
		
		if (con != null){
			try {
				con.close();
			} catch(Exception e){
				e.printStackTrace();
			}
			
			con = null;
		}
	}
	
	public static ResultSet executeQuery(String sql, String[] parameters){
		try{
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			if (parameters != null){
				for (int i = 0;i < parameters.length;i++)
					ps.setString(i + 1, parameters[i]);
			}
			
			rs = ps.executeQuery();

		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} 
		
		return rs;
	}
}
