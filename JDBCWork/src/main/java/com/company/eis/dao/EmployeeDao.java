package com.company.eis.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface EmployeeDao {
	boolean validateUser (String username, String password, Connection connection) throws SQLException;
	void displayInsuranceScheme(String username, Connection connection) throws SQLException;
}
