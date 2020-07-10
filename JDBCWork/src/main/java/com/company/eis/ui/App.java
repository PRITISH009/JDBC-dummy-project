package com.company.eis.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.company.eis.service.EmployeeServiceSchemeImpl;

public class App 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		try {
			
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Creating Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employs", "root", "");
			
			//Start Service
			EmployeeServiceSchemeImpl service = new EmployeeServiceSchemeImpl();
			service.App(connection);
			
			
		} catch (SQLException e) {
			
			// Check if proper connection is created
			System.out.println("Failed to build a connection to the database");
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			
			// Check if JDBC driver was loaded correctly
			System.out.println("DataBase Error");
			// Not handled properly yet..
			e.printStackTrace();
		
		}
	}
    
	
	
	
}
