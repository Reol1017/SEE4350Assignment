package sse4350;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class View extends Controller{
	
	public static void main(String[] args)throws SQLException{ 
		// Connect to database
		Connection conn;
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		String url = "jdbc:mysql://localhost:3316/db1?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "Wk1106526116";
		conn = DriverManager.getConnection(url,user,password);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Query or Insert: ");
		String C = sc.nextLine();
		if(C.equals("Query")) {
		System.out.println("Input ID");
		int ID = sc.nextInt();
		fetchdata(conn,ID);
		sc.close();
		}
		else if(C.equals("Insert")) {
			System.out.println("Input ID:");
			int ID = sc.nextInt();
			System.out.println("Input Name:");
			String Name = sc.next();
			System.out.println("Input Math Mark:");
			double Math = sc.nextDouble();
			System.out.println("Input Science Mark:");
			double Science = sc.nextDouble();
			insertdata(conn,ID,Name,Math,Science);
		}
		
}

}