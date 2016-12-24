package cn.zq.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WorkState_db {
	
	private String db_url = "jdbc:mysql://localhost:3306/workstate";//连接数据库的JDBC URL
	private String db_user = "root"; 		//数据库的用户名
	private String db_pwd = "hello";				//数据库的密码
	private Connection con = null;
    private PreparedStatement prepStmt = null;
    
	public  WorkState_db()
	{	
		try{
			Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动类
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws Exception
	{
		return java.sql.DriverManager.getConnection(db_url, db_user, db_pwd);//建立与数据库的连接
	}
	
	public void db_close(Connection con,PreparedStatement prepStmt,ResultSet rs) //依次关闭ResultSet，PreparedStatement，Connection
	{
		try
		{
			if (rs != null){
				rs.close();
			}
			
			if (prepStmt != null){
				prepStmt.close();
			} 
			
			if (con != null){
				con.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	// state = "#mj2016121301,0,1,000000,u"
	public void insertState(String state){
		HeartBeat hb = new HeartBeat(state);

		try
		{
			con = getConnection();
			String sql = "insert into heartbeat values(?,?,?,?)";//需要执行的sql语句
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1,String.valueOf(hb.getId()));
			prepStmt.setString(2,String.valueOf(hb.getState()));
			prepStmt.setString(3,String.valueOf(hb.getDoorstate()));
			prepStmt.setString(4,String.valueOf(hb.getGroupID()));
			prepStmt.executeUpdate();	
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			db_close(con,prepStmt,null);
		}
	}
	// state = "#mj2016121301,0,1,000000,u"
	public boolean udpateState(String state){
		
		
		return true;
	}
	// state = "#mj2016121301,0,1,000000,u"
	public boolean deleteState(String state){
		
		return true;
	}
}

