-- Create database
CREATE DATABASE sms;

drop database sms;
-- Use database
USE sms;

-- Customer table
CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL
);

-- Employee table
CREATE TABLE Employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    supervisor_id INT,
    FOREIGN KEY (supervisor_id) REFERENCES Employee(employee_id)
);

-- Product table
CREATE TABLE Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    list_price DECIMAL(10,2) NOT NULL
);

-- Orders table
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATETIME NOT NULL,
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    total DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

-- LineItem table
CREATE TABLE LineItem (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2),
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);

DELIMITER //
create procedure insert_customer(in customer_name VARCHAR(255))
begin
	insert into Customer(customer_name)values(customer_name);
end;
 //
 
DELIMITER ;

CALL insert_customer('Debra Burks');
CALL insert_customer('Kasha Todd');
CALL insert_customer('Tameka Fisher');
CALL insert_customer('Daryl Spence');
CALL insert_customer('Charolette Rice');


DELIMITER //
create procedure insert_employee(employee_name VARCHAR(255),salary DECIMAL(10,2),supervisor_id INT)
begin
	insert into Employee(employee_name ,salary ,supervisor_id) value(employee_name ,salary ,supervisor_id );
end; 
//
DELIMITER ;

CALL insert_employee('Fabiola Jackson', 3000.00, NULL);
CALL insert_employee('Mireya Copeland', 2800.00, 1);
CALL insert_employee('Genna Serrano', 2700.00, 2);
CALL insert_employee('Virgie Wiggins', 2700.00, 2);
CALL insert_employee('Jannette David', 2900.00, 1);
DELIMITER //

CREATE PROCEDURE add_product_simple(
    IN p_name VARCHAR(255),
    IN p_price DECIMAL(10,2)
)
BEGIN
    INSERT INTO Product(product_name, list_price)
    VALUES (p_name, p_price);
END //

DELIMITER ;

CALL add_product_simple('Trek 820 - 2016', 379.99);
CALL add_product_simple('Ritchey Timberwolf Frameset - 2016', 749.99);
CALL add_product_simple('Surly Wednesday Frameset - 2016', 999.99);
CALL add_product_simple('Trek Fuel EX 8 29 - 2016', 2899.99);
CALL add_product_simple('Heller Shagamaw Frame - 2016', 1320.99);
CALL add_product_simple('Surly Ice Cream Truck Frameset - 2016', 469.99);
CALL add_product_simple('Trek Slash 8 27.5 - 2016', 3999.99);
CALL add_product_simple('Trek Remedy 29 Carbon Frameset - 2016', 1799.99);
CALL add_product_simple('Trek Conduit+ - 2016', 2999.99);
CALL add_product_simple('Surly Straggler - 2016', 1549.00);

DELIMITER //

CREATE PROCEDURE add_order(
    IN p_order_date DATETIME,
    IN p_customer_id INT,
    IN p_employee_id INT,
    IN p_total DECIMAL(10,2)
)
BEGIN
    INSERT INTO Orders(order_date, customer_id, employee_id, total)
    VALUES (p_order_date, p_customer_id, p_employee_id, p_total);
END //

DELIMITER ;
CALL add_order('2016-01-01 00:00:00', 1, 2, NULL);
CALL add_order('2016-01-01 00:00:00', 2, 5, NULL);
CALL add_order('2016-01-02 00:00:00', 3, 5, NULL);
CALL add_order('2016-01-03 00:00:00', 4, 3, NULL);
CALL add_order('2016-01-03 00:00:00', 5, 4, NULL);


DELIMITER //
CREATE PROCEDURE insert_lineitem_simple(
    IN p_order_id INT,
    IN p_product_id INT,
    IN p_quantity INT,
    IN p_price DECIMAL(10,2)
)
BEGIN
    INSERT INTO LineItem(order_id, product_id, quantity, price)
    VALUES (p_order_id, p_product_id, p_quantity, p_price);
END //

DELIMITER ;


CALL insert_lineitem_simple(1, 10, 1, 599.99);
CALL insert_lineitem_simple(1, 8, 2, 1799.99);
CALL insert_lineitem_simple(1, 4, 1, 2899.99);

CALL insert_lineitem_simple(2, 10, 1, 599.99);
CALL insert_lineitem_simple(3, 3, 1, 999.99);
CALL insert_lineitem_simple(3, 10, 1, 599.99);
CALL insert_lineitem_simple(4, 2, 2, 749.99);


-- 1) List all customers consist of customer id, customer name in the database, returns a 
-- list with all customers in the order table. 
select * from customer;
select * from orders;
DROP PROCEDURE IF EXISTS list_customers_oders;
Delimiter //
create procedure list_customers_orders()
begin

select c.customer_id,c.customer_name
from customer c
inner join orders o 
on c.customer_id = o.customer_id;
end //

Delimiter ; 

call list_customers_orders();


-- 2) List all orders consist of order id, order date, customer id, employee id, total for a 
-- customer, returns a list with all the orders for a given customer id. 
select * from customer;
select * from orders;
select * from LineItem;
delimiter //
create procedure list_orders_by_customer(in p_customer_id int)
begin
select o.order_id,
o.order_date,
o.customer_id,
o.employee_id,
sum(l.quantity * l.price) as total
from orders o
inner join LineItem l on o.order_id = l.order_id
where o.customer_id = p_customer_id
group by o.order_id,
o.order_date,
o.customer_id,
o.employee_id;
end //

delimiter ;

call list_orders_by_customer(3);


-- 3) List all line items for an order, returns a list with all line items for a given order id. 
-- liệt kê tất cả các sản phẩm của một đơn hàng trả về một danh sách theo order_id được truyền vào
select * from orders;
select * from product;
select * from LineItem ;

delimiter //
create  procedure list_prodouct(in l_order_id int)
begin 
select l.order_id, p.product_name 
from LineItem l
inner join product p
on l.product_id = p.product_id
where l.order_id = l_order_id;
end //
delimiter ;

call list_prodouct(1)

-- 4) Compute order total (quantity * price) from the line items for a given order id. You 
-- must use an User Define Function. 
-- 4) Tính tổng giá trị của một đơn hàng (quantity * price) từ các line item 
-- cho một order_id được cung cấp. Bạn phải sử dụng User Defined Function.
select * from orders;
select * from LineItem ;

DROP FUNCTION IF EXISTS total_product_orderid;
delimiter //
create function total_product_orderid(p_order_id int)
returns decimal(10,2)
READS	SQL	DATA
begin 
declare total decimal(10,2);
select sum(quantity * price) into total
from LineItem 
where order_id = p_order_id;
return total;
end //
delimiter ;

select total_product_orderid(1);


-- 5) Add a customer into the database, you must use a Stored Procedure. 
select * from customer;
 drop procedure if exists add_customer;
delimiter //
create procedure add_customer(in customer_name varchar(255))
begin
	insert into customer(customer_name)value(customer_name);
end //
delimiter ;
ALTER TABLE Customer AUTO_INCREMENT = 6;

call add_customer('nhung');
SHOW TABLE STATUS LIKE 'Customer';


-- 6) Delete a customer from the database, make sure to also delete Orders and LineItem 
-- for the deleted customer. You must use a Stored Procedure. 
 drop procedure if exists delete_customer;
select * from orders;
select * from LineItem ;
select * from customer;

delimiter //
create procedure delete_customer(IN p_customer_id INT)

begin 
delete from LineItem 
where order_id in
(
select order_id
from orders
 WHERE customer_id = p_customer_id
);
-- 2. Xóa Orders
DELETE FROM Orders
WHERE customer_id = p_customer_id;

-- 3. Xóa Customer
DELETE FROM Customer
WHERE customer_id = p_customer_id;

END //

delimiter ;

call delete_customer(7);
-- 7) Update a customer in the database, you must use a Stored Procedure. 
select * from orders;
select * from LineItem ;
select * from customer;
 drop procedure if exists update_custumer_infor;
delimiter //
create procedure update_custumer_infor(in p_customer_id int ,p_customer_name varchar(255))
begin
	update customer
    set customer_name = p_customer_name
    where customer_id = p_customer_id;

end //

delimiter ;

call update_custumer_infor(8,'tram');
-- 8) Create an order into the database. 

select * from orders;
select * from LineItem ;
select * from customer;
select * from employee;
drop procedure if exists  create_order;
delimiter //

create procedure create_order(in p_customer_id int,in p_order_date date,p_employee_id INT)
begin
	insert orders(customer_id,order_date,employee_id) value(p_customer_id,curdate(),p_employee_id);

end //

delimiter ;
call create_order(8,'2016-01-01 00:00:00',2);
-- 9) Create a LineItem into the database. 
select * from orders;
select * from LineItem ;
select * from product;
drop procedure if exists create_LineItem;
delimiter //

create procedure create_LineItem 
(in p_order_id int,in p_product_id int,p_quantity int,price decimal(10,2))
begin
	insert LineItem (order_id,product_id,quantity,price) value(p_order_id,p_product_id,p_quantity,price);

end //

delimiter ;

call create_LineItem(1,3,7,1000);
-- 10) Update an order total into the database. 
select * from orders;
select * from LineItem ;
select * from product;
drop procedure if exists  Update_order_total;
delimiter //
create function Update_order_total(p_order_id int)
returns decimal(10,2)
READS	SQL	DATA
begin
 declare total decimal(10,2);
 select sum(quantity * price) into total 
 from LineItem
 where order_id = p_order_id;
 return total;
end //
delimiter ;

select Update_order_total(1);

drop procedure if exists  Update_order_total2;
delimiter //
create procedure Update_order_total2(p_order_id int)
begin
update orders 
set total = Update_order_total(p_order_id)
where order_id = p_order_id;

end //
delimiter ;

call Update_order_total2(1);

