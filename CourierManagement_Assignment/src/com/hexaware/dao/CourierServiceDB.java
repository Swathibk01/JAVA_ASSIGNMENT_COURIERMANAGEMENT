package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Couriers;
import com.hexaware.util.DBPropertyUtil;

public class CourierServiceDB {
	
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;
	private Connection con;

    public CourierServiceDB() {
       con = DBPropertyUtil.getMyDbConnection();
    }
	

	public String authenticateUser(int userID, String password) {
		String result = "false";
		try {
			con= DBPropertyUtil.getMyDbConnection();
			ps = con.prepareStatement("SELECT * FROM users WHERE userId = ? and password = ?");
			ps.setInt(1, userID);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				result = "true";
			}
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
		return result;
	}
	
    public boolean authenticateEmployee(int empUserID, String password) {

    	 if (con== null) {
             System.out.println("Connection is null. Cannot authenticate.");
             return false;}
        String query = "SELECT * FROM employees WHERE name = ? AND password = ?";
        try {
        	con= DBPropertyUtil.getMyDbConnection();

			PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, empUserID);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If result set has next, authentication successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Authentication failed
    }

    public boolean authenticateCustomer(String username, String password) {
    	
        String query = "SELECT * FROM Users WHERE Name = ? AND Password = ?";
        try {    	

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If result set has next, authentication successful

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Authentication failed
    }
    public List<Couriers> getAvailableCouriers() throws SQLException {
        List<Couriers> couriers = new ArrayList<>();
        String query = "SELECT * FROM couriers WHERE availability = true AND capacity >= ?"; // Assuming you have a table named 'couriers'

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, 200); 

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int courierId = rs.getInt("courierId");
                int capacity = rs.getInt("capacity");
                boolean availability = rs.getBoolean("availability");
                couriers.add(new Couriers(courierId, capacity, availability));
            }
        }

        return couriers;
    }
}
