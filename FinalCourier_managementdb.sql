-- creating database and tables 
create database Courier_management;
use Courier_management;

-- creating tables 
CREATE TABLE Users (
    UserID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    ContactNumber VARCHAR(20),
    Address TEXT
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    UserID INT,
    OrderDate DATE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE CourierServices (
    ServiceID INT PRIMARY KEY,
    ServiceName VARCHAR(100),
    Cost DECIMAL(8, 2)
);

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    ContactNumber VARCHAR(20),
    Role VARCHAR(50),
    Salary DECIMAL(10, 2)
);

CREATE TABLE Couriers (
    CourierID INT PRIMARY KEY,
    SenderName VARCHAR(255),
    SenderAddress TEXT,
    ReceiverName VARCHAR(255),
    ReceiverAddress TEXT,
    Weight DECIMAL(5, 2),
    Status VARCHAR(50),
    TrackingNumber VARCHAR(20) UNIQUE,
    DeliveryDate DATE,
    OrderID INT,
    ServiceID INT,
    employeeid int,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ServiceID) REFERENCES CourierServices(ServiceID),
    foreign key (employeeid) references employees(employeeid)
);
ALTER TABLE orders
ADD COLUMN trackingNumber VARCHAR(50); -- Change VARCHAR(50) to match your tracking number's length

select  * from orders;

create table parcel(
	packageid int primary key,
    orderid int,
    courierid int,
    weight decimal(5, 2),
    status varchar(25),
    deliverydate date,
    foreign key (orderid) references orders(orderid),
	foreign key (courierid) references couriers(courierid)
);


CREATE TABLE Locations (
    LocationID INT PRIMARY KEY,
    LocationName VARCHAR(100),
    Address TEXT
);

CREATE TABLE Payments (
    PaymentID INT PRIMARY KEY,
    CourierID INT,
    LocationID INT,
    Amount DECIMAL(10, 2),
    PaymentDate DATE,
    FOREIGN KEY (CourierID) REFERENCES Couriers(CourierID),
    FOREIGN KEY (LocationID) REFERENCES Locations(LocationID)
);

INSERT INTO Users (UserID, Name, Email, Password, ContactNumber, Address)
VALUES	
    (14, 'Sophie Thompson', 'sophie.thompson@email.com', 'sophie@pass123', '7890123456', '789 Oak St'),
    (15, 'Henry Davis', 'henry.davis@email.com', 'henry_pass', '6543210987', '456 Pine St'),
    (16, 'Grace Miller', 'grace.miller@email.com', 'grace@123', '9876543210', '321 Elm Ave'),
    (17, 'Logan White', 'logan.white@email.com', 'logan_pass', '8765432109', '789 Birch St'),
    (18, 'Ella Brown', 'ella.brown@email.com', 'ella@pass', '3456789012', '234 Cedar Ave'),
    (19, 'Noah Smith', 'noah.smith@email.com', 'noah_pass', '8901234567', '567 Maple St');

INSERT INTO Orders (OrderID, UserID, OrderDate)
VALUES
    (13, 14, '2023-12-07'),
    (14, 15, '2023-11-29'),
    (15, 16, '2023-11-17'),
    (16, 17, '2023-11-29'),
    (17, 18, '2023-12-02'),
    (18, 19, '2023-12-04'),
    (19 ,19, '2023-12-04');
    
INSERT INTO CourierServices (ServiceID, ServiceName, Cost)
VALUES
    (12, 'Next Day Delivery', 35.99),
    (13, 'Economy Delivery', 15.99),
    (14, 'International Delivery', 50.99),
    (15, 'Same Day Delivery', 45.99),
    (16, 'Standard Delivery', 20.99),
    (17, 'Express Delivery', 30.99),
    (18, 'Superfast Delivery', 40.99),
    (19, 'Two-Day Delivery', 25.99);
select * from couriers;
INSERT INTO Employees (EmployeeID, Name, Email, ContactNumber, Role, Salary)
VALUES
    (13, 'Liam Thompson', 'liam.thompson@email.com', '555-4321', 'Customer Service', 2700.00),
    (14, 'Chloe Wright', 'chloe.wright@email.com', '555-8765', 'Courier Driver', 3100.00),
    (15, 'Benjamin White', 'benjamin.white@email.com', '555-9876', 'Management', 4000.00),
    (16, 'Emma Davis', 'emma.davis@email.com', '666-4321', 'Courier Driver', 3200.00),
    (17, 'Mia Smith', 'mia.smith@email.com', '666-5678', 'operations', 2500.00),
    (18, 'Lucas Miller', 'lucas.miller@email.com', '666-6543', 'technical staff', 4000.00),
    (19, 'Ava Taylor', 'ava.taylor@email.com', '777-1234', 'it admin', 3100.00),
    (20, 'Jackson Brown', 'jackson.brown@email.com', '777-5678', 'Customer support', 2500.00);

INSERT INTO Couriers (CourierID, SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate, OrderID, ServiceID, employeeid)
VALUES
    (13, 'Grace Miller', '321 Elm Ave' , 'Noah Smith', '567 Maple St', 3.2, 'In Transit', 'TN123567', '2023-12-10', 13, 12,13),
    (14, 'Logan White', '789 Birch St', 'Ella Brown', '234 Cedar Ave', 2.9, 'Delivered', 'TN123678', '2023-12-03', 14, 12,14),
    (15, 'Ella Brown', '234 Cedar Ave ', 'Sophie Thompson', '789 Oak St', 4.5, 'Pending', 'TN123789', '2023-11-29', 15, 13,15),
    (16, 'Noah Smith', '567 Maple St', 'Henry Davis', '456 Pine St', 3.6, 'Delivered', 'TN123890', '2023-12-01', 16, 14,14),
    (17, 'Sophie Thompson', '789 Oak St', 'Logan White', '789 Birch St', 3.1, 'In Transit', 'TN123901','2023-11-28', 17,17,16),
    (18, 'Henry Davis', '456 Pine St', 'Grace Miller', '321 Elm Ave', 4.2, 'Delivered', 'TN123012', '2023-12-05', 18, 17,13),
    (19, 'Noah smith', '567 Maple St', 'Logan White', '789 Birch St', 3.9, 'Pending', 'TN10326', '2023-12-08', 19, 13, 15);
    ALTER TABLE couriers
ADD COLUMN capacity INT,
ADD COLUMN availability BOOLEAN;
-- Update capacity and availability for existing couriers
UPDATE couriers SET capacity = 150, availability = true WHERE courierid = 13;
UPDATE couriers SET capacity = 200, availability = true WHERE courierid = 14;
UPDATE couriers SET capacity = 120, availability = false WHERE courierid = 15;
UPDATE couriers SET capacity = 180, availability = false WHERE courierid = 16;
UPDATE couriers SET capacity = 150, availability = true WHERE courierid = 17;
UPDATE couriers SET capacity = 180, availability = false WHERE courierid = 18;
UPDATE couriers SET capacity = 180, availability = false WHERE courierid = 19;
select * from shipment;	


CREATE TABLE shipment (
    shipment_id INT AUTO_INCREMENT PRIMARY KEY,
    weight DECIMAL(5, 2),
    status VARCHAR(20),
    courierid INT
);
drop table shipment;
insert into shipment(shipment_id,weight,status,courierid) values 
	(1,  1.2, 'In warehouse', '13'),
    (2,  1.4, 'At courier office', '13'),
    (3,  1.9, 'In warehouse', '14'),
    (4,  2.0, 'Out for delivery', '16');
insert into parcel(packageid, orderid, courierid, weight, status, deliverydate)
values
	(1, 13, 13, 1.2, 'In warehouse', '2023-12-11'),
    (2, 13, 13, 1.4, 'At courier office', '2023-12-12'),
    (3, 14, 14, 1.9, 'In warehouse', '2023-12-05'),
    (4, 16, 16, 2.0, 'Out for delivery', '2023-12-01');


INSERT INTO Locations (LocationID, LocationName, Address)
VALUES
    (11, 'Warehouse F', '789 Industrial Blvd'),
    (12, 'Warehouse G', '456 Commerce Ave'),
    (13, 'Branch Office 5', '123 Factory St'),
    (14, 'Warehouse H', '987 Business St'),
    (15, 'Branch Office 6', '654 Manufacturing Ave'),
    (16, 'Warehouse I', '321 Enterprise St'),
    (17, 'Branch Office 7', '789 Production Ave'),
    (18, 'Warehouse J', '456 Operations St');

INSERT INTO Payments (PaymentID, CourierID, LocationID, Amount, PaymentDate)
VALUES
    (12, 13, 11, 22.99, '2023-12-14'),
    (13, 14, 12, 30.99, '2023-11-30'),
    (14, 15, 13, 18.99, '2023-11-21'),
    (15, 16, 13, 25.99, '2023-12-04'),
    (16, 17, 15, 21.99, '2023-11-30'),
    (17, 18, 16, 55.00, '2023-12-06'),
    (18, 13, 16, 23.00, '2023-12-15');



-- Task 2
-- 1. List all customers:
SELECT * FROM Users;

-- 2. List all orders for a specific customer:
SELECT * FROM Orders WHERE UserID = 14;

-- 3. List all couriers:
SELECT * FROM Couriers;

-- 4. List all packages for a specific order:
SELECT * FROM parcel WHERE OrderID = 13;

-- 5. List all deliveries for a specific courier:
select * from couriers where courierid = 17; 

-- 6. List all undelivered packages:
select * from parcel where status != 'Delivered';

-- 7. List all packages that are scheduled for delivery today:
select * from parcel where DeliveryDate = Curdate();

-- 8. List all packages with a specific status:
select * from parcel where Status = 'out for delivery';

-- 9. Calculate the total number of packages for each courier:
select c.courierid, count(p.packageid) as totalpackages from couriers c join parcel p on c.courierid = p.courierid group by c.courierid;

-- 10. Find the average delivery time for each courier:
select avg(datediff(c.DeliveryDate, o.OrderDate)) as AvgDeliveryTime from Couriers c 
join Orders o on c.OrderID = o.OrderID where c.Status = 'Delivered';

-- 11. List all packages with a specific weight range:
select * from parcel where Weight between 1.5 and 2.0;

-- 12. Retrieve employees whose names contain 'John':
select * from Employees WHERE Name LIKE '%John%';

-- 13. Retrieve all courier records with payments greater than $50:
select c.*, p.amount from couriers c join payments p on c.courierid = p.courierid where p.amount > 50.00;

-- Task 3
-- 14. Find the total number of couriers handled by each employee:
select e.EmployeeID, e.Name as EmployeeName, COUNT(c.CourierID) as TotalCouriersHandled from Employees e
left join Couriers c on e.EmployeeID = c.EmployeeID
group by e.EmployeeID, e.Name;


-- 15. Calculate the total revenue generated by each location:
select l.locationid, l.locationname, sum(p.amount) as totalrevenue from locations l 
left join payments p on l.locationid = p.locationid group by l.locationid, l.locationname;

-- 16. Find the total number of couriers delivered to each location:
select Receiveraddress, count(courierid) as totalcouriers from couriers where status = 'Delivered' group by receiveraddress;

-- 17. Find the courier with the highest average delivery time:
select courierid, datediff(c.DeliveryDate, o.OrderDate) as DeliveryTime from Couriers c 
join Orders o on c.OrderID = o.OrderID where c.Status = 'Delivered' order by DeliveryTime desc limit 1;

-- 18. Find Locations with Total Payments Less Than a Certain Amount:
select l.locationid, l.locationname, sum(p.amount) as totalpayment from locations l 
left join payments p on l.locationid = p.locationid group by l.locationid, l.locationname having sum(p.amount) < 26.00;

-- 19. Calculate Total Payments per Location:
select locationid, count(*) as totalpayments from payments group by locationid;

-- 20. Retrieve couriers who have received payments totaling more than $1000 in a specific location (LocationID = X)
select c.courierid, sum(p.amount) as totalpayment from couriers c 
join payments p on c.courierid = p.courierid where p.locationid = 11 group by c.courierid having sum(p.amount) > 1000.00;


-- 21. Retrieve couriers who have received payments totaling more than $1000 after a certain date (PaymentDate > 'YYYY-MM-DD'):
select c.courierid, SUM(p.Amount) as TotalPayments from Couriers c 
join Payments p on c.CourierID = p.CourierID where p.PaymentDate > '2023-10-01' group by c.CourierID, c.SenderName, c.ReceiverName having SUM(p.Amount) > 1000.00;

-- 22. Retrieve locations where the total amount received is more than $5000 before a certain date (PaymentDate > 'YYYY-MM-DD'):
select l.LocationID, l.LocationName, SUM(p.Amount) as TotalPayments from Locations l 
left join Payments p ON l.LocationID = p.LocationID where p.PaymentDate > '2023-10-01' group by l.LocationID, l.LocationName having SUM(p.Amount) > 5000.00;

-- 23. Retrieve Payments with Courier Information:
select p.*, c.* from payments p join couriers c on p.courierid = c.courierid ;

-- Task 4
-- 24. Retrieve Payments with Location Information:
select p.*, l.* from payments p join locations l on p.locationid = l.locationid;

-- 25. Retrieve Payments with Courier and Location Information:
select p.*, c.*, l.* from payments p join couriers c on p.courierid = c.courierid inner join locations l on p.locationid = l.locationid;

-- 26. List all payments with courier details:
select p.*, c.* from Payments p join Couriers c ON p.CourierID = c.CourierID;

-- 27. Total payments received for each courier:
select c.CourierID, SUM(p.Amount) as TotalPayments from Couriers c left join Payments p on c.CourierID = p.CourierID group by c.CourierID;

-- 28. List payments made on a specific date:
select * from Payments where PaymentDate = '2023-11-21';

-- 29. Get Courier Information for Each Payment:
select p.*, c.* from payments p join couriers c on p.courierid = c.courierid;

-- 30. Get Payment Details with Location:
select p.*, l.* from Payments p join Locations l ON p.LocationID = l.LocationID;

-- 31. Calculating Total Payments for Each Courier:
select c.CourierID, SUM(p.Amount) as TotalPayments from Couriers c left join Payments p on c.CourierID = p.CourierID group by c.CourierID;

-- 32. List Payments Within a Date Range:
select * from payments where PaymentDate between '2023-11-20' and '2023-12-01';

-- 33. Retrieve a list of all users and their corresponding courier records, including cases where there are no matches on either side
select u.*, c.* from users u left join couriers c on u.name = c.sendername union select u.*, c.* from users u right join couriers c on u.name = c.sendername;

-- 34. Retrieve a list of all couriers and their corresponding services, including cases where there are no matches on either side:
select c.*, cs.* from Couriers c left join CourierServices cs on c.ServiceID = cs.ServiceID 
union select c.*, cs.* from Couriers c right join CourierServices cs on c.ServiceID = cs.ServiceID;

-- 35. Retrieve a list of all employees and their corresponding payments, including cases where there are no matches on either side:
select e.*, p.PaymentID, p.Amount as PaymentAmount, p.PaymentDate from Employees e
left join Couriers c on e.EmployeeID = c.employeeid
left join Payments p on c.CourierID = p.CourierID;

-- 36. List all users and all courier services, showing all possible combinations:
select u.*, cs.* from users u cross join courierservices cs;

-- 37. List all employees and all locations, showing all possible combinations:
select e.*, l.* from employees e cross join locations l;

-- 38. Retrieve a list of couriers and their corresponding sender information (if available):
select c.*, u.* from couriers c left join users u on c.sendername = u.name;

-- 39. Retrieve a list of couriers and their corresponding receiver information (if available):
select c.*, u.* from couriers c left join users u on c.receivername = u.name;

-- 40. Retrieve a list of couriers along with the courier service details (if available):
select c.*, cs.* from couriers c left join courierservices cs on c.serviceid = cs.serviceid;

-- 41. Retrieve a list of employees and the number of couriers assigned to each employee:
select e.employeeid, e.name, count(c.courierid) as totalcouriers from employees e 
left join couriers c on e.employeeid = c.employeeid group by e.employeeid, e.name;

-- 42. Retrieve a list of locations and the total payment amount received at each location:
select l.LocationID, l.LocationName, sum(p.Amount) as TotalPayments from Locations l 
left join Payments p ON l.LocationID = p.LocationID group by l.LocationID, l.LocationName;

-- 43. Retrieve all couriers sent by the same sender (based on SenderName):
select c1.* from Couriers c1
join Couriers c2 on c1.SenderName = c2.SenderName and c1.CourierID <> c2.CourierID;

-- 44. List all employees who share the same role:
select e1.* from Employees e1 join Employees e2 on e1.Role = e2.Role AND e1.EmployeeID <> e2.EmployeeID;

-- 45. Retrieve all payments made for couriers sent from the same location:
select p1.* from Payments p1 join Payments p2 on p1.LocationID = p2.LocationID AND p1.PaymentID <> p2.PaymentID;

-- 46. Retrieve all couriers sent from the same location (based on SenderAddress):
select c1.* from  Couriers c1 join Couriers c2 on c1.SenderAddress = c2.SenderAddress AND c1.CourierID != c2.CourierID;

-- 47. List employees and the number of couriers they have delivered:
select e.employeeid, e.name, count(c.courierid) as totalcouriers from employees e 
left join couriers c on e.employeeid = c.employeeid where c.status = 'delivered' group by e.employeeid, e.name;

-- 48. Find couriers that were paid an amount greater than the cost of their respective courier service:
select c.*, p.* from couriers c join payments p on c.courierid = p.courierid join courierservices cs on c.serviceid = cs.serviceid where p.amount > cs.cost;

-- Task 5
-- 49. Find couriers that have a weight greater than the average weight of all couriers:
select * from couriers where weight > (select avg(weight) from couriers);

-- 50. Find the names of all employees who have a salary greater than the average salary:
select Name from employees where salary > (select avg(salary) from employees); 

-- 51. Find the total cost of all courier services where the cost is less than the maximum cost:
select sum(cost) from courierservices where cost < (select max(cost) from courierservices);

-- 52. Find all couriers that have been paid for:
select * from couriers where courierid in (select courierid from payments);

-- 53. Find the locations where the maximum payment amount was made:
select l.*, p.amount as maxamount from locations l join payments p on l.locationid = p.locationid where p.amount = (select max(amount) from payments); 

-- 54. Find all couriers whose weight is greater than the weight of all couriers sent by a specific sender (e.g., 'SenderName'):
select * from couriers where weight >all (select weight from couriers where sendername = 'Sophie Thompson');

-- Adding the 'password' column to the 'employees' table
ALTER TABLE employees ADD COLUMN password VARCHAR(255);
-- Update 'employees' table with password values
UPDATE employees SET password = 'password1' WHERE EmployeeID = 13;
UPDATE employees SET password = 'password2' WHERE EmployeeID = 14;
UPDATE employees SET password = 'password3' WHERE EmployeeID = 15;
UPDATE employees SET password = 'password4' WHERE EmployeeID = 16;
UPDATE employees SET password = 'password5' WHERE EmployeeID = 17;
UPDATE employees SET password = 'password5' WHERE EmployeeID = 18;
UPDATE employees SET password = 'password5' WHERE EmployeeID = 19;
UPDATE employees SET password = 'password5' WHERE EmployeeID = 20;

-- Create the table
CREATE TABLE TrackingHistoryEntry (
    dateTime TIMESTAMP,
    location VARCHAR(255),
    status VARCHAR(50)
);

-- Insert three sample values
INSERT INTO TrackingHistoryEntry (dateTime, location, status)
VALUES 
    ('2023-12-16 10:30:00', 'Location A', 'In Transit'),
    ('2023-12-16 11:45:00', 'Location B', 'In Transit'),
    ('2023-12-16 13:20:00', 'Location C', 'Delivered');
