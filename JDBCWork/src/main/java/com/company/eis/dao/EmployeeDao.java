package com.company.eis.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface EmployeeDao {
	boolean validateUser (String username, String password, Connection connection) throws SQLException;
	Employee displayInsuranceScheme(String username, Connection connection) throws SQLException;
}
