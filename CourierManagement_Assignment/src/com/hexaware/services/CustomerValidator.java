package com.hexaware.services;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hexaware.util.DBPropertyUtil;

public class CustomerValidator {
    // Assuming you have a connection to the database
    private Connection connection;
    private Connection con;

    public CustomerValidator() {
       con = DBPropertyUtil.getMyDbConnection();
    }
	

    public boolean validateCustomerData(String data, String detail) {
        if (data == null || data.isEmpty()) {
            return false;
        }

        switch (detail.toLowerCase()) {
            case "name":
                return validateName(data);
            case "address":
                return validateAddress(data);
            case "phonenumber":
                return validatePhoneNumber(data);
            default:
                return false;
        }
    }

    private boolean validateName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private boolean validateAddress(String address) {
        return !address.matches("[^a-zA-Z0-9 ]");
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }
}
