package com.hexaware.services;

import java.sql.SQLException;

public interface ICourierAdminService {
    int addCourierStaff(int employeeID,String name, String contactNumber);

	void displayOrdersOfSpecificCustomer(int userID);

	void parcelCategorizer(double parcelWeight);

	void assignCouriers() throws SQLException;

}

