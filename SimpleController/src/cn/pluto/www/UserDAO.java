package cn.pluto.www;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class UserDAO {
	private static String url = "";
	private static String driver = "";
	private static String username = "";
	private static String password = "";
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	static Properties prop = null;
	static FileInputStream fis = null;

	static {
		try{
			prop = new Properties();
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			fis = new FileInputStream(path + "dbinfo.properties");
			prop.load(fis);
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
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
	
	public  Connection openDBConnection(){
		try{
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public  boolean closeDBConnection(){
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
		
		if (conn != null){
			try {
				conn.close();

			} catch(Exception e){
				e.printStackTrace();
				return false;
			}	
			conn = null;
			return true;
		}
		
		return true;
	}
	
	public UserBean queryUser(String userName){
		String sql = "select * from user where name=?";
		UserBean ub = new UserBean();
		
		try{
			conn = openDBConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			
			if (rs != null){
				if (rs.next()){
					String password = rs.getString(2);
					ub.setUsername(userName);
					ub.setPassword(password);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		closeDBConnection();

		return ub;
	}
	
	public boolean insertUser(UserBean u){
		int result = 0;
		String sql = "insert into user values(?, ?)";
		
		try{
			conn = openDBConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			result = ps.executeUpdate();
		}catch(Exception e){
			;
		}
	
		
		closeDBConnection();
		
		if (result == 1)
			return true;
		else
			return false;
	}
	
	public boolean updateUser(UserBean u){
		int result = 0;
		String sql = "update user set name=?, pwd=? where name=?";
		
		try{
			conn = openDBConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getUsername());
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		closeDBConnection();
		
		if (result == 1)
			return true;
		else
			return false;
	}
	
	public boolean deleteUser(UserBean u){
		int result = 0;
		String sql = "delete from user where name=?";
		
		try{
			conn = openDBConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		closeDBConnection();
		
		if (result == 1)
			return true;
		else
			return false;
	}
}
