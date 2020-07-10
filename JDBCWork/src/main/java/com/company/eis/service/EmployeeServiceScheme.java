package com.company.eis.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface EmployeeServiceScheme {
	
	boolean validateUser(String username, String password, Connection connection) throws SQLException;
	void App(Connection connection) throws SQLException;
	void displayInsuranceScheme(String username, Connection connection) throws SQLException;
}
