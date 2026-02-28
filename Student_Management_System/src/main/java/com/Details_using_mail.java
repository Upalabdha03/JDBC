package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Details_using_mail {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter mail");
		
		String mail = sc.nextLine();
		
		
		String Details = "SELECT * FROM student_details WHERE Student_EmailId = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iem", "root", "root");
			System.out.println("Driver Loaded");
			
			PreparedStatement ps = con.prepareStatement(Details);
			// Set email parameter
            ps.setString(1, mail);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {

                int id = rs.getInt("Student_ID");
                String name = rs.getString("Student_Name");
                double percentage = rs.getDouble("Student_Percentage");
                String email = rs.getString("Student_degree");

                System.out.println("Student Found:");
                System.out.println(id + " " + name + " " + percentage + " " + email);
            } 
            else {
                System.out.println("Student Not Present");
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
