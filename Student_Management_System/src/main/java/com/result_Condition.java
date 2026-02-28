package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class result_Condition {
	
	public static void main(String[] args) {
		
		
		String select = "Select * from student_details where Student_Percentage > ?";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iem?user=root&password=root");
			System.out.println("connection done");
			
			PreparedStatement ps = con.prepareStatement(select);
			ps.setDouble(1,70);
			
			 ResultSet resultSet = ps.executeQuery();
			 boolean empty = true;

	            while (resultSet.next()) {
	            	
	            	empty = false;

	                int id = resultSet.getInt("Student_ID");
	                String name = resultSet.getString("Student_Name");
	                double percentage = resultSet.getDouble("Student_Percentage");
	                String stream = resultSet.getString("Student_Stream");
	                String degree = resultSet.getString("Student_degree");
	                
	                

	                System.out.println(id + " " + name + " " + percentage +" "+ stream +" "+degree);
	            }

	            con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
