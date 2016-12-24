package cn.pluto.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlTest {

	public static void main(String[] args) {
		String sql = "select * from users where username=?";
		String parameters[] = {"test"};
		ResultSet rs = null;
		String result = null;
	
		rs = SqlHelper.executeQuery(sql, parameters);
		try {
			if (rs.next())
				result = rs.getString(2);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		SqlHelper.close();

		System.out.println("password = " + result);
	}
}
