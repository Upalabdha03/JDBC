package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class student_details_mysql {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		

       

        // Taking inputs
		
       // System.out.print("Enter Student ID: ");
       // int studentId = sc.nextInt();
       // sc.nextLine();   // clear buffer

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student Percentage: ");
        double studentPercentage = sc.nextDouble();
        sc.nextLine();   // clear buffer

        System.out.print("Enter Student Stream: ");
        String studentStream = sc.nextLine();

        System.out.print("Enter Student Degree: ");
        String studentDegree = sc.nextLine();

        System.out.print("Enter Student Email ID: ");
        String studentEmail = sc.nextLine();

        System.out.print("Enter Student Gender: ");
        String studentGender = sc.nextLine();

        System.out.print("Enter Student DOB (dd-mm-yyyy): ");
        String studentDOB = sc.nextLine();

        System.out.print("Enter Student Mobile Number: ");
        String studentMobile = sc.nextLine();
		
		
		String insert = "insert into iem.student_details ( Student_Name, Student_Percentage, Student_Stream, Student_degree, Student_EmailId, Student_Gender, Student_DOB, Student_Mobile_Number) values(?,?,?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Successful");
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection succesful");
			
			
			PreparedStatement preparedStatent = con.prepareStatement(insert); 
			
			//preparedStatent.setInt(1, studentId);
			preparedStatent.setString(1, studentName);
			preparedStatent.setDouble(2, studentPercentage);
			preparedStatent.setString(3, studentStream);
			preparedStatent.setString(4, studentDegree);
			preparedStatent.setString(5, studentEmail);
			preparedStatent.setString(6, studentGender);
			
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        LocalDate dob = LocalDate.parse(studentDOB, formatter);
		        preparedStatent.setDate(7, Date.valueOf(dob));
			
			preparedStatent.setString(8, studentMobile);
			
			System.out.println("platform created");
			
			int result  = preparedStatent.executeUpdate();
			if(result != 0) {
				System.out.println("inserted successful");
			}
			else
			{
				System.out.println("not inserted");
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
