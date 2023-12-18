package com.hexaware.dao;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hexaware.entity.Couriers;
import com.hexaware.services.ICourierAdminService;
import com.hexaware.util.DBPropertyUtil;

import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class CourierAdminService implements ICourierAdminService{
	    private Connection connection;


	    public CourierAdminService() {
	       connection = DBPropertyUtil.getMyDbConnection();
	    }

	    public void displayOrdersOfSpecificCustomer(int customerId) {
	        if (connection == null) {
	            System.out.println("Connection is null. Cannot retrieve orders.");
	            return;
	        }

	        String query = "SELECT * FROM orders WHERE UserID= ?";
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, customerId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            // Displaying orders for the specific customer
	            while (resultSet.next()) {
	                int orderId = resultSet.getInt("orderId");
	                String orderDate = resultSet.getString("orderDate"); // Assuming the column name is order_date
	                // Display or process the order details accordingly
	                System.out.println("Order ID: " + orderId + ", Order Date: " + orderDate);
	            }

	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Other methods...
	    
	

		public void parcelCategorizer(double parcelWeight) {
			 if (parcelWeight < 3) {
		            System.out.println("Parcel is categorized as Light.");
		        } else if (parcelWeight < 5) {
		            System.out.println("Parcel is categorized as Medium.");
		        } else {
		            System.out.println("Parcel is categorized as Heavy.");
		        }
			// TODO Auto-generated method stub
			
		}

		public int addCourierStaff(int employeeID,String name, String contactNumber) {
	        if (connection == null) {
	            System.out.println("Connection is null. Cannot add courier staff.");
	            return -1; // Return a negative value indicating failure
	        }

	        String query = "INSERT INTO Employees(EmployeeID ,Name, contactNumber) VALUES (?,?, ?)";
	        int newStaffId = -1;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
	            preparedStatement.setInt(1, employeeID); 
	            preparedStatement.setString(2, name);
	            preparedStatement.setString(3, contactNumber);
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected > 0) {
	             
	                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	                if (generatedKeys.next()) {
	                    newStaffId = generatedKeys.getInt(1);
	                    System.out.println("Courier staff added. Staff ID: " + newStaffId);
	                }
	            }
	            
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return newStaffId;
	    }

		public void assignCouriers() throws SQLException {
			// TODO Auto-generated method stubtry (Connection connection = getConnection()) {
            CourierServiceDB courierDAO = new CourierServiceDB();
            List<Couriers> availableCouriers = null;
			try {
				availableCouriers = courierDAO.getAvailableCouriers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            String updateShipmentQuery = "UPDATE shipment SET courierid = ? WHERE shipment_id = ?";
            try (PreparedStatement updateStmt = connection.prepareStatement(updateShipmentQuery)) 
                {for (Couriers courier : availableCouriers) {
                    // Your assignment logic based on predefined criteria (e.g., capacity)
                    if (courier.getCapacity() >= 240) {
                        int assignedCourierId = courier.getCourierID();

                        // Get a shipment to assign to the courier
                        String getShipmentQuery = "SELECT shipmentid FROM shipment WHERE courierid IS NULL AND status = 'InWarehouse' LIMIT 1";
                        try (PreparedStatement getShipmentStmt = connection.prepareStatement(getShipmentQuery)) {
                            ResultSet rs = getShipmentStmt.executeQuery();
                            if (rs.next()) {
                                int shipmentId = rs.getInt("shipmentid");
                                updateStmt.setInt(1, assignedCourierId);
                                updateStmt.setInt(2, shipmentId);
                                updateStmt.executeUpdate();

                                System.out.println("Assigned courier " + assignedCourierId + " toshipment " + shipmentId);
                            }
                        }
                    }
                }}catch (SQLException e) {
                    e.printStackTrace();
                }
		}
            
	}
	

