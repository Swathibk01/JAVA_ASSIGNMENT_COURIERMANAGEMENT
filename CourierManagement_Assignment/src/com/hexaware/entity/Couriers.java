package com.hexaware.entity;

import java.util.Date;

public class Couriers {
    private int courierID;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private double weight;
    private String status;
    private String trackingNumber;
    private Date deliveryDate;
    public Couriers(int courierId2, int capacity, boolean availability) {
		// TODO Auto-generated constructor stub
	}
	public Couriers() {
		// TODO Auto-generated constructor stub
	}
	public int getCourierID() {
		return courierID;
	}
	public void setCourierID(int courierID) {
		this.courierID = courierID;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int userId;
	@Override
	public String toString() {
		return "Courier [courierID=" + courierID + ", senderName=" + senderName + ", senderAddress=" + senderAddress
				+ ", receiverName=" + receiverName + ", receiverAddress=" + receiverAddress + ", weight=" + weight
				+ ", status=" + status + ", trackingNumber=" + trackingNumber + ", deliveryDate=" + deliveryDate
				+ ", userId=" + userId + "]";
	}
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}


  
}
