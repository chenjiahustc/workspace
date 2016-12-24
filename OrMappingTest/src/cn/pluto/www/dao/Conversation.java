package cn.pluto.www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.pluto.www.UserBean;

public class Conversation {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	static {
		try{
			System.out.println(Configuration.getDriver());
			Class.forName(Configuration.getDriver());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection openDBConnection(){
		try{
			conn = DriverManager.getConnection(Configuration.getUrl(), 
					Configuration.getUsername(), Configuration.getPassword());
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static boolean closeDBConnection(){
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

	public static UserBean getUser(String key, String value){
		UserBean ub = new UserBean();
		String table = null;
		String column = null;
		
		//通过Configuration查询到key所对应的的列
		OrMappingClass omcTarget = null;
		OrMappingProperty ompTarget = null;
		for(OrMappingClass omc : Configuration.getOrMappingclassList()){
			if ("UserBean".equals(omc.getName())){
				omcTarget = omc;
			}
		}
		
		table = omcTarget.getTable();
		for(OrMappingProperty omp : omcTarget.getProperties()){
			if (key.equals(omp.getName()))
				column = omp.getColumn();
		}
		
		String sql = "select * from " + table + " where " + column + "=?";
		String[] params = new String[]{value};
		
		rs = query(sql, params);
		
		try{
			if (rs != null){
				if(rs.next()){
					ub.setUsername(rs.getString(2));
					ub.setPassword(rs.getString(3));
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			closeDBConnection();
		}
		
		return ub;
	}
	
	public static UserBean getUser(int id){
		UserBean ub = null;
		
		return ub;
	}
		
	public static ResultSet query(String sql, String[] params){
		try{
			conn = openDBConnection();
			ps = conn.prepareStatement(sql);
			for(int i = 0;i < params.length;i++){
				ps.setString(i + 1, params[i]);
			}
			
			rs = ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
}
