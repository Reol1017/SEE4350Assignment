package sse4350;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




	public class  Controller extends Model{
		
		
		
		//Read data from database
		public static void fetchdata(Connection conn,int ID){
			
			int studentId = ID;
			String studentName = null;
			double MathMark = 0;
			double ScienceMark = 0;
		try 
		{
			Statement statement = conn.createStatement();
			String sql = "select * from Student where id ='"+studentId+"'";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("---------------------------------------------------");
			System.out.println(" ");
			System.out.println("ID" + "\t\t" + "Name" + "\t\t" + "Math" + "\t\t" + "Science");
			System.out.println("---------------------------------------------------");
			while(rs.next()) {
			studentId = rs.getInt("id");
			studentName = rs.getString("Name");
			MathMark = rs.getDouble("Math");
			ScienceMark = rs.getDouble("Science");
			System.out.println(studentId + "\t\t" + studentName + "\t" + MathMark + "\t\t" + ScienceMark);
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
				System.out.println("Read data successfully!"+"\n");
		}
		
		 // Storing data to Model
			Model Storing = new Model();
			Storing.setID(studentId);
			Storing.setName(studentName);
			Storing.setMath(MathMark);
			Storing.setScience(ScienceMark);
		}
		
		
		
		
		
		//Insert data to database
		public static void insertdata(Connection conn,int ID,String Name,double M, double S) {
			int studentID = ID;
			String NAME = Name;
			double Math = M;
			double Science = S;
			try
			{
				PreparedStatement psql = conn.prepareStatement("insert into Student (id,Name,Math,Science)"+"values(?,?,?,?)");
				psql.setInt(1, studentID); 
				psql.setString(2, NAME);
				psql.setDouble(3, Math);
				psql.setDouble(4, Science);
				psql.executeUpdate();  
				psql.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
					System.out.println("Insert data successfully!"+"\n");
			}
	
		
		}
		
		
				
}