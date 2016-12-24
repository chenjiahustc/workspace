package cn.pluto.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class J2ee_db {
	private DataSource ds = null;
	
	public J2ee_db() throws Exception{
		Context ctx = new InitialContext();
		
		if (ctx == null)
			throw new Exception("No Context");
		
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/j2ee_db");
	}
	
	public Connection getConnection() throws Exception{
		return ds.getConnection();
	}
	
	public void closeConnection(Connection con){
		try {
			if (con != null)
				con.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closePrepStmt(PreparedStatement prepStmt){
		try{
			if (prepStmt != null)
				prepStmt.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closeResultSet(ResultSet rs){
		try{
			if (rs != null)
				rs.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getPassword(String Username) throws Exception{
		String password = null;
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try{
			con = getConnection();
			String selectStatement = "select * from users where Username=?";
			prepStmt = con.prepareStatement(selectStatement);
			prepStmt.setString(1,  Username);
			rs = prepStmt.executeQuery();
			
			if (rs.next())
				password = rs.getString(2);
			
		} finally{
			closeResultSet(rs);
			closePrepStmt(prepStmt);
			closeConnection(con);
		}
		
		return password;
	}
}

