package com.company.eis.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.company.eis.dao.EmployeeDaoImpl;

public class EmployeeServiceSchemeImpl implements EmployeeServiceScheme{
	
	EmployeeDaoImpl dao = new EmployeeDaoImpl();
	
	@Override
	public void App(Connection connection) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		boolean status=false;
		
		System.out.println("To see you Insurance Criteria please Enter the following details ");
		//Taking User Input 
		do {
			System.out.print("Username - ");
			String username = sc.nextLine();
			
			System.out.print("Password - ");
			String password = sc.nextLine();
			
			status = validateUser(username, password, connection);
			//System.out.println(status);
			if(status) {
				// Show Scheme
				// No database interaction should take place in this page.... This package is Only meant for User interaction...
				displayInsuranceScheme(username, connection);
			}else {
				// Print Wrong credentials and ask for credentials again
				System.out.println("Either the Username or Password was wrong... Please Enter the correct credentials\n");
			}
		}while(!status);
		
		sc.close();
		connection.close();
	}

	@Override
	public boolean validateUser(String username, String password, Connection connection) throws SQLException {
		// Interact with a dao method that intern interact with the database to validate the user.
		 return dao.validateUser(username, password, connection);
	}

	@Override
	public void displayInsuranceScheme(String username, Connection connection) throws SQLException {
		// Interact with the dao method that intern interacts with the database and get user salary and user designation and gives the Insurance Scheme
		dao.displayInsuranceScheme(username, connection);
	}

	
}
