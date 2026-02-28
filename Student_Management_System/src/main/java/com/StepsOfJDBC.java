package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.*;

public class StepsOfJDBC {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//System.out.println("enter employee id");
		//int id = scanner.nextInt();
		System.out.println("enter employees name");
		String name = scanner.next();
		//System.out.println("enter emailid");
		//String emailid = scanner.next();
		System.out.println("enter mobilenumber");
		long mb = scanner.nextLong();
		
		System.out.println("enter employee deptno");
		int deptno = scanner.nextInt();
		System.out.println("enter salary");
		double salary = scanner.nextDouble();
		
		
		String insert = "insert into iem.employee ( emp_name, emp_mobile_number, emp_deptno, emp_salary )values (?,?,?,?)";
		
		
		
		
		
		/* Load the Driver Class */
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded Successfully...");
			
			
			/* 2) Establich the connection */
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection successful");
			
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			System.out.println("before specified" +preparedStatement);
			
			//setting the values
			//preparedStatement.setInt(1, id);
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2, mb);
			
			preparedStatement.setInt(3,deptno);
			preparedStatement.setDouble(4,salary);
			System.out.println("after specified" +preparedStatement);
			
			System.out.println("platform created");
			
			// execute
			
			int result = preparedStatement.executeUpdate();
			
			if(result != 0)
			{
				System.out.println("data inserted successfull");
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

