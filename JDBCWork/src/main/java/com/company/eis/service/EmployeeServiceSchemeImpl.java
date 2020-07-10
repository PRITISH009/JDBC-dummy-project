package com.company.eis.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.company.eis.bean.Employee;
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
		Employee employee = dao.displayInsuranceScheme(username, connection);
		
		if(employee.getSalary() <5000 && employee.getDesignation().contentEquals("Clerk")) {
			System.out.println("No Scheme");
		}else if(employee.getSalary() >=5000 && employee.getSalary() < 20000 && employee.getDesignation().contentEquals("System Associate") ) {
			System.out.println("Scheme C");
		}else if(employee.getSalary() >= 20000 && employee.getSalary() < 40000 && employee.getDesignation().contentEquals("Programmer")) {
			System.out.println("Scheme B");
		}else if(employee.getSalary() >= 40000 && employee.getDesignation().contentEquals("Manager")) {
			System.out.println("Scheme A");
		}else {
			System.out.println("No Scheme Yet...");
		}
	}

	
}
