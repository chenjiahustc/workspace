package postgresql_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) {
		System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

		try {
		
		        Class.forName("org.postgresql.Driver");
		
		} catch (ClassNotFoundException e) {
	
	        System.out.println("Where is your PostgreSQL JDBC Driver? "
	                        + "Include in your library path!");
	        e.printStackTrace();
	        return;
	
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");
		
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/j2ee_db", "root",
		                        "hello");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
        String sql = "select * from users where name='test'";
        try{
        	Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                 //取出列值
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                System.out.println(username+"," + password + ",");
            }
        } catch(Exception e){
        	e.printStackTrace();
        }
        
        
	}

}
