package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllEmployeeDetails {
	public static void main(String[] args) {
		
		
		String select = "select * from iem.student_details";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/iem?user=root&password=root");
			System.out.println("connection done");
			
			
			PreparedStatement ps = con.prepareStatement(select);
			
		ResultSet resultSet =	ps.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("data existed");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
