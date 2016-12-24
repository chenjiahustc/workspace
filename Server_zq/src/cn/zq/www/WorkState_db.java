package cn.zq.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WorkState_db {
	
	private String db_url = "jdbc:mysql://localhost:3306/workstate";//�������ݿ��JDBC URL
	private String db_user = "root"; 		//���ݿ���û���
	private String db_pwd = "hello";				//���ݿ������
	private Connection con = null;
    private PreparedStatement prepStmt = null;
    
	public  WorkState_db()
	{	
		try{
			Class.forName("com.mysql.jdbc.Driver");//����mysql������
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws Exception
	{
		return java.sql.DriverManager.getConnection(db_url, db_user, db_pwd);//���������ݿ������
	}
	
	public void db_close(Connection con,PreparedStatement prepStmt,ResultSet rs) //���ιر�ResultSet��PreparedStatement��Connection
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
			String sql = "insert into heartbeat values(?,?,?,?)";//��Ҫִ�е�sql���
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

