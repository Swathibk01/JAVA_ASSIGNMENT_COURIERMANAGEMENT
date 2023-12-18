package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.util.DBPropertyUtil;

public class EmployeeDAO {
    private Connection connection=DBPropertyUtil.getMyDbConnection();	

    // Example method to check if an employee ID exists
    public boolean doesEmployeeIdExist(int employeeId) throws SQLException {
    	 if (connection == null) {
             throw new SQLException("Connection is null.");
         }
        String query = "SELECT COUNT(*) AS count FROM employees WHERE employeeid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        }
        return false;
    }
}
