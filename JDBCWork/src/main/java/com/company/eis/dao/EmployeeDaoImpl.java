package com.company.eis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.eis.bean.Employee;


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
	public Employee displayInsuranceScheme(String username, Connection connection) throws SQLException{
		
		//SQL Query that returns the Salary and Designation of the (Already validated) User.
		String query = "Select Name, Salary, Designation from Employee where UserID = ?";
		
		PreparedStatement pr = connection.prepareStatement(query);
		pr.setNString(1, username);
		
		ResultSet result = pr.executeQuery();
		result.next();
		
		Employee employee = new Employee(username, result.getString(1), Integer.parseInt(result.getString(2)), result.getString(3));
		
		return employee;
	}

}

