package com.hexaware.entity;

public class Employees {
    private int employeeID;
    private String Name;
    private String email;
    private long contactNumber;
    private String role;
    private double salary;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + Name + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", salary=" + salary + "]";
	}

}
