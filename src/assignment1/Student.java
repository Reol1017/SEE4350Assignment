package assignment1;

import java.sql.*; 

public class Student {
	
	
	public static void main(String[] args) throws SQLException { 
		// Connect to database
		Connection connection = null;
		Statement s = null;
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		String url = "jdbc:mysql://localhost:3316/db1?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "Wk1106526116";
		connection = DriverManager.getConnection(url,user,password);
		s = connection.createStatement();
		ResultSet rs = s.executeQuery ("Select * from Student");
		ResultSetMetaData rsmd =rs.getMetaData(); 
		int i =rsmd.getColumnCount( );
		
		for(int j=1; j<=i; j++) { 
			System.out.print(rsmd.getColumnName(j)+"\t"); 
			System.out.print(" "); 
		} 

		// Print records
		while(rs.next( ) ) { 
			for(int j=1; j<=i; j++) 
			{ 
				System.out.print ( rs.getString( j)+"\t"); 
			}
		}

	}
}