package com.company.eis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDaoImpl implements EmployeeDao{
	
	@Override
	public boolean validateUser(String username, String password, Connection connection) throws SQLException {
		
		//SQL Query that returns 1 if a user with the given userID and password EXISTS else 0
		String query = "Select Exists(Select UserId from Employee where UserId = ? and Password = ?)";
		
		PreparedStatement pr =  connection.prepareStatement(query);
		pr.setNString(1, username);
		pr.setNString(2, password);
		
		ResultSet result = pr.executeQuery();
		result.next();
		return (result.getString(1).contentEquals("1") ? true : false);
	}

	@Override
	public void displayInsuranceScheme(String username, Connection connection) throws SQLException{
		
		int salary;
		String designation;
		
		//SQL Query that returns the Salary and Designation of the (Already validated) User.
		String query = "Select Salary, Designation from Employee where UserID = ?";
		
		PreparedStatement pr = connection.prepareStatement(query);
		pr.setNString(1, username);
		
		ResultSet result = pr.executeQuery();
		result.next();
		
		salary = Integer.parseInt(result.getString(1));
		designation = result.getString(2);
		//System.out.println(salary + " , " + designation);
		
		if(salary <5000 && designation.contentEquals("Clerk")) {
			System.out.println("No Scheme");
		}else if(salary >=5000 && salary < 20000 ) {
			System.out.println("Scheme C");
		}else if(salary >= 20000 && salary < 40000) {
			System.out.println("Scheme B");
		}else if(salary >= 40000) {
			System.out.println("Scheme A");
		}else {
			System.out.println("No Scheme Yet...");
		}
	}

}
