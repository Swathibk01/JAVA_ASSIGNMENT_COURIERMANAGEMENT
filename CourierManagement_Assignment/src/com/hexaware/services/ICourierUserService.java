package com.hexaware.services;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.entity.Couriers;
import com.hexaware.exception.TrackingNumberNotFoundException;

public interface ICourierUserService {
  

    String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException, SQLException;

    boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException, SQLException;



	String placeOrder(Couriers courier) throws SQLException;




}
