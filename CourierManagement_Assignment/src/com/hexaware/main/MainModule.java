package com.hexaware.main;
import com.hexaware.services.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import com.hexaware.exception.*;
import com.hexaware.dao.*;
import com.hexaware.entity.*;

	public class MainModule {
	    public static void main(String[] args) throws SQLException {
	       
	        CourierAdminService adminService = new CourierAdminService();
	        CourierUserService userService = new CourierUserService();
	    	EmployeeDAO employeeDAO = new EmployeeDAO();
	        CustomerValidator validator = new CustomerValidator();
	        AddressComparator comparator = new AddressComparator();

			AddressFormatter formatter = new AddressFormatter();
			
            Scanner scanner=new Scanner(System.in);
            System.out.println("Select Role:");
            System.out.println("1. Employee");
            System.out.println("2. Customer");
            System.out.print("Enter your choice: ");
            int roleChoice = scanner.nextInt();

        switch (roleChoice) {
            case 1:
               
            	try {
                    System.out.print("Enter employee ID: ");
                    int empId = scanner.nextInt();
                    if (!employeeDAO.doesEmployeeIdExist(empId)) {
                        throw new InvalidEmployeeIdException("Invalid Employee ID: " + empId);
                    } else {
                        System.out.println("Employee ID exists: " + empId);
                System.out.println("1. Display Orders of Specific Customer");
                System.out.println("2. Parcel Categorizer");
                System.out.println("3. Add courier Staff");
                System.out.println("4. Assign couriers");
                System.out.println("5. Enter tracking history details");
                System.out.println("6. validate customer");
                System.out.println("7. Address Formatter");
                System.out.println("8. Address Comparator");
                System.out.print("Enter your choice: ");
                
                int employeeChoice = scanner.nextInt();
                
                switch (employeeChoice) {
                    case 1:
                    	System.out.println("Enter customerID ");
                    	int userID= scanner.nextInt();
                        adminService.displayOrdersOfSpecificCustomer(userID);
                        break;
                    case 2:
                    	System.out.println("Enter Weight ");
                    	double parcelWeight=scanner.nextDouble();
                        adminService.parcelCategorizer(parcelWeight);
                        break;
                    case 3:
                    	System.out.println("Enter Employee Id");
                    	int EmployeeID=scanner.nextInt();
                    	System.out.println("Enter Employee name");
                    	String Name=scanner.next();
                    	System.out.println("Enter Employee Contact");
                    	String contactNumber=scanner.next();
                    	
                        adminService.addCourierStaff(EmployeeID,Name, contactNumber);
                        System.out.println("Courier staff added. Staff ID: " + EmployeeID);
                        break;
                    case 4:
                    	System.out.println("Enter assigned courierid");
                    	int assignedCourierId=scanner.nextInt(); 
                    	System.out.println("Enter shipment id");
                    	int shipmentId=scanner.nextInt();     
                    	adminService.assignCouriers();

                        break;
                    case 5:

                    	System.out.println("Enter number of tracking history entries:");
                        int numEntries = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        TrackingHistoryEntry[] trackingHistory = new TrackingHistoryEntry[numEntries];

                        for (int i = 0; i < numEntries; i++) {
                            System.out.println("Enter date and time (YYYY-MM-DD HH:mm:ss):");
                            String dateTimeStr = scanner.nextLine();
                            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);

                            System.out.println("Enter location:");
                            String location = scanner.nextLine();

                            System.out.println("Enter status:");
                            String status = scanner.nextLine();

                            trackingHistory[i] = new TrackingHistoryEntry(dateTime, location, status);
                        }

                        ParcelTrackingService parcelTrackingService = new ParcelTrackingService();
                        boolean isAdded = parcelTrackingService.addTrackingHistory(trackingHistory);

                        if (isAdded) {
                            System.out.println("Tracking history added successfully.");
                        } else {
                            System.out.println("Failed to add tracking history.");
                        }
                    case 6:
                    	System.out.println("Enter customer information to validate:");
                        System.out.print("Detail (name/address/phone number): ");
                        String detail = scanner.next();
                        System.out.print("Customer data: ");
                        String data = scanner.next();
                        boolean isValid = validator.validateCustomerData(data, detail);
                        if (isValid) {
                            System.out.println("Customer data is valid!");
                        } else {
                            System.out.println("Invalid customer data.");
                        }break;
                    case 7: 
                    	System.out.println("Enter Street: ");
                    String street = scanner.nextLine();

                    System.out.println("Enter City: ");
                    String city = scanner.nextLine();

                    System.out.println("Enter State: ");
                    String state = scanner.nextLine();

                    System.out.println("Enter Zip Code: ");
                    String zipCode = scanner.nextLine();

                    String formattedAddress = formatter.formatAddress(street, city, state, zipCode);
                    System.out.println("Formatted Address: " + formattedAddress);

                    break;
                    case 8:
                    	 System.out.println("Enter the first address:");
                         String address1 = scanner.next();

                         System.out.println("Enter the second address:");
                         String address2 = scanner.next();

                         boolean similarAddresses = comparator.areAddressesSimilar(address1, address2);

                         if (similarAddresses) {
                             System.out.println("The addresses are similar.");
                         } else {
                             System.out.println("The addresses are not similar.");
                         }break;
				default:
                        System.out.println("Invalid choice");
                        break;
                
                }}}
                     catch (InvalidEmployeeIdException e) {
                    System.out.println("Caught InvalidEmployeeIdException: " + e.getMessage());}
                
                break;
              
            case 2:
            
                System.out.println("1. Place Order");
                System.out.println("2. Check Order Status");
                System.out.println("3. Cancel Order");
                System.out.println("4. generate password");
                System.out.print("Enter your choice: ");
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1:
                    	Couriers Courier = new Couriers();
                		Scanner input=new Scanner(System.in);
                		System.out.println("Enter Userid: ");
                		int UserID = input.nextInt();
                		System.out.println("Enter courierid: ");
                		int courierID = input.nextInt();
                		Courier.setCourierID(courierID);
                		System.out.println("Enter sender's name: ");
                		String senderName = input.next();
                		Courier.setSenderName(senderName);
                		
                		System.out.println("Enter sender's address: ");
                		String senderAddress = input.next();
                		Courier.setSenderAddress(senderAddress);
                		
                		System.out.println("Enter receiver's name: ");
                		String receiveraddress = input.next();
                		Courier.setReceiverName(receiveraddress);
                		
                		System.out.println("Enter receiver's address: ");
                		String receiverAddress = input.next();
                		Courier.setReceiverAddress(receiverAddress);
                		userService.placeOrder(Courier);
                		System.out.println("Order placed successfully ");

                        break;
                    case 2:
                    	System.out.print("Enter Tracking number: ");
                    	
                        String trackingNumber=scanner.next();
                        
                    	try {
                    	
                        String status=userService.getOrderStatus(trackingNumber);
                        System.out.println("Status :" + status);
                            
                    } catch (SQLException e) {
                        e.printStackTrace();
                        // Handle SQLException
                    } catch (TrackingNumberNotFoundException e) {
                        System.out.println("Tracking number not found: " + e.getMessage());
                        // Handle TrackingNumberNotFoundException
                    }
                    	
                        break;
                    case 3:
                    	System.out.print("Enter Tracking number: ");
                    	String trackingNumber1=scanner.next();
                    	  
                    	try {
                    	
        					userService.cancelOrder(trackingNumber1);
                                System.out.println("Order cancelled");
                             
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (TrackingNumberNotFoundException e) {
                        System.out.println("Tracking number not found: " + e.getMessage());
                    }   break;
                    case 4: int passwordLength = 12; 
                    String generatedPassword = PasswordGenerator.generatePassword(passwordLength);
                    System.out.println("Generated Password: " + generatedPassword);
                    	break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                break;
            
            
            default:
                System.out.println("Invalid choice");
                break;
                
        }    }

		
	}

