package com.hexaware.entity;


import java.util.List;

public class CourierCompany {
    private String companyName;
 
    private List<Couriers> courierDetails;
    private List<Employees> employeeDetails;
    private List<Location> locationDetails;

    // Default constructor
    public CourierCompany() {
        // Initialize if needed
    }

    // Parameterized constructor
    public CourierCompany(String companyName, List<Couriers> courierDetails, 
                          List<Employees> employeeDetails, List<Location> locationDetails) {
        this.companyName = companyName;
        this.courierDetails = courierDetails;
        this.employeeDetails = employeeDetails;
        this.locationDetails = locationDetails;
    }

    // Getters and setters for companyName
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Getters and setters for courierDetails
    public List<Couriers> getCourierDetails() {
        return courierDetails;
    }

    public void setCourierDetails(List<Couriers> courierDetails) {
        this.courierDetails = courierDetails;
    }

    // Getters and setters for employeeDetails
    public List<Employees> getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(List<Employees> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    // Getters and setters for locationDetails
    public List<Location> getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(List<Location> locationDetails) {
        this.locationDetails = locationDetails;
    }

    // toString() method
    @Override
    public String toString() {
        return "CourierCompany{" +
                "companyName='" + companyName + '\'' +
                ", courierDetails=" + courierDetails +
                ", employeeDetails=" + employeeDetails +
                ", locationDetails=" + locationDetails +
                '}';
    }

}
