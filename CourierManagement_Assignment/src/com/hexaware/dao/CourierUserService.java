package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hexaware.entity.*;
import com.hexaware.exception.TrackingNumberNotFoundException;
import com.hexaware.services.ICourierUserService;
import com.hexaware.util.DBPropertyUtil;
public class CourierUserService implements ICourierUserService {
    private CourierServiceDB courierDAO;
    Connection con=DBPropertyUtil.getMyDbConnection();	
    public CourierUserService() {
        this.courierDAO = new CourierServiceDB();
    }

        	
    public String placeOrder(Couriers courier) throws SQLException {
        String sql = "INSERT INTO couriers(CourierID, SenderName, SenderAddress, ReceiverName,ReceiverAddress) VALUES (?,?, ?, ?,?)";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
        	
          statement.setInt(1, courier.getCourierID());
            statement.setString(2, courier.getSenderName());
            statement.setString(3, courier.getSenderAddress());
            statement.setString(4, courier.getReceiverName());
            statement.setString(5, courier.getReceiverAddress());
            statement.executeUpdate();
        }
		return sql;
    }
    

    @Override
    public boolean cancelOrder(String trackingNumber1) throws TrackingNumberNotFoundException,SQLException {
        try {
        	        String sql = "DELETE FROM couriers WHERE TrackingNumber = ?";
        	        try (PreparedStatement statement1 = con.prepareStatement(sql)) {
        	  
        	                statement1.setString(1, trackingNumber1);
        	                return statement1.executeUpdate() > 0;
        	            }
        	        
        	    
        	    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getOrderStatus(String trackingNumber) throws SQLException,TrackingNumberNotFoundException {
    	String sql = "SELECT Status FROM Couriers WHERE trackingnumber = ?";
        
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, trackingNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("Status");
                } else {
                    throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
                }
            }
        }
    }






    // Other methods...
}