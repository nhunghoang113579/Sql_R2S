create database bikestore;
drop database bikestore;
drop table categories;
use bikestore;
create table stores(
store_id int auto_increment primary key,
store_name varchar(255),
phone varchar(255),
email varchar(255),
street varchar(255),
city varchar(255),
state varchar(10),
zip_code varchar(255));

create table customers(
customer_id int auto_increment primary key,
first_name varchar(255),
last_name varchar(255),
phone varchar(255),
email varchar(255),
street varchar(255),
city varchar(255),
state varchar(255),
zip_code varchar(255)
);
create table categories(
category_id int auto_increment primary key,
category_name varchar(255)
);
create table brands(
brand_id int auto_increment primary key,
brand_name varchar(255)
);
create table staffs(
staff_id int auto_increment primary key,
first_name varchar(50),
last_name varchar(50),
email varchar(255),
phone varchar(25),
active tinyint,
store_id int,
manager_id int,
foreign key(store_id)references stores(store_id)
);

create table orders(
order_id int auto_increment primary key,
customer_id int,
order_status tinyint,
order_date date,
required_date date,
shipped_date date,
store_id int,
staff_id int,
foreign key(store_id)references stores(store_id),
foreign key(staff_id) references staffs(staff_id),
foreign key(customer_id)references customers(customer_id)
);

create table products(
product_id int auto_increment primary key,
product_name varchar(255),
brand_id int,
category_id int,
model_year smallint,
list_price decimal(10,2),
foreign key(brand_id)references brands(brand_id),
foreign key(category_id)references categories(category_id)
);
CREATE TABLE stocks(
store_id INT,
product_id INT,
quantity INT,
PRIMARY KEY(store_id,product_id),
FOREIGN KEY(store_id) REFERENCES stores(store_id),
FOREIGN KEY(product_id) REFERENCES products(product_id)
);
create table order_items(
item_id int auto_increment primary key,
order_id int,
product_id int,
quantity int,
list_price decimal(10,2),
discount decimal(4,2),
foreign key(order_id)references orders(order_id),
foreign key(product_id) references products(product_id)

);

insert into brands(brand_name) value('Electra'),
('Haro'),
('Heller'),
('Pure Cycles'),
('Ritchey'),
('Strider'),
('Sun Bicycles'),
('Surly'),
('Trek');

insert into categories(category_name) value('Children Bicycles'),
('Comfort Bicycles'),
('Cruisers Bicycles'),
('Cyclocross Bicycles'),
('Electric Bikes'),
('Mountain Bikes'),
('Road Bikes');

insert into products(product_name,brand_id,category_id,model_year,list_price)values
('Trek 820 - 2016', 9, 6, 2016, 379.99),
('Ritchey Timberwolf Frameset - 2016', 5, 6, 2016, 749.99),
('Surly Wednesday Frameset - 2016', 8, 6, 2016, 999.99),
('Trek Fuel EX 8 29 - 2016', 9, 6, 2016, 2899.99),
('Heller Shagamaw Frame - 2016', 3, 6, 2016, 1320.99),
('Surly Ice Cream Truck Frameset - 2016', 8, 6, 2016, 469.99),
('Trek Slash 8 27.5 - 2016', 9, 6, 2016, 3999.99),
('Trek Remedy 29 Carbon Frameset - 2016', 9, 6, 2016, 1799.99),
('Trek Conduit+ - 2016', 9, 5, 2016, 2999.99),
('Surly Straggler - 2016', 8, 4, 2016, 1549.00);

INSERT INTO stores
(store_name, phone, email, street, city, state, zip_code)
VALUES
('Santa Cruz Bikes','(831) 476-4321','santacruz@bikes.shop','3700 Portola Drive','Santa Cruz','CA','95060'),
('Baldwin Bikes','(516) 379-8888','baldwin@bikes.shop','4200 Chestnut Lane','Baldwin','NY','11432'),
('Rowlett Bikes','(972) 530-5555','rowlett@bikes.shop','8000 Fairway Avenue','Rowlett','TX','75088');

INSERT INTO customers
(first_name, last_name, phone, email, street, city, state, zip_code)
VALUES
('Debra','Burks',NULL,'debra.burks@yahoo.com','9273 Thorne Ave.','Orchard Park','NY','14127'),
('Kasha','Todd',NULL,'kasha.todd@yahoo.com','910 Vine Street','Campbell','CA','95008'),
('Tameka','Fisher',NULL,'tameka.fisher@aol.com','769C Honey Creek St.','Redondo Beach','CA','90278'),
('Daryl','Spence',NULL,'daryl.spence@aol.com','988 Pearl Lane','Uniondale','NY','11553'),
('Charolette','Rice','(916) 381-6003','charolette.rice@msn.com','107 River Dr.','Sacramento','CA','95820');





INSERT INTO stocks (store_id, product_id, quantity ) VALUES
(1,1,27),
(1,2,5),
(1,3,6),
(1,4,23),
(1,5,22),
(1,6,0),
(1,7,8),
(1,8,0),
(1,9,11),
(1,10,15);

INSERT INTO staffs 
(first_name,last_name,email,phone,active,store_id,manager_id)
VALUES
('Fabiola','Jackson','fabiola.jackson@bikes.shop','(831)555-5554',1,1,NULL),
('Mireya','Copeland','mireya.copeland@bikes.shop','(831)555-5555',1,1,1),
('Genna','Serrano','genna.serrano@bikes.shop','(831)555-5556',1,1,2),
('Virgie','Wiggins','virgie.wiggins@bikes.shop','(831)555-5557',1,1,2),
('Jannette','David','jannette.david@bikes.shop','(516)379-4444',1,2,1);

INSERT INTO orders
(customer_id,order_status,order_date,required_date,shipped_date,store_id,staff_id)
VALUES
(1,4,'2016-01-01','2016-01-03','2016-01-03',1,2),
(2,4,'2016-01-01','2016-01-04','2016-01-03',2,5),
(3,4,'2016-01-02','2016-01-05','2016-01-03',2,5),
(4,4,'2016-01-03','2016-01-04','2016-01-05',1,3),
(5,4,'2016-01-03','2016-01-06','2016-01-06',2,4);

INSERT INTO order_items
(order_id,product_id,quantity,list_price,discount)
VALUES
(1,10,1,599.99,0.20),
(1,8,2,1799.99,0.07),
(1,10,2,1549.00,0.05),
(1,10,2,599.99,0.05),
(1,4,1,2899.99,0.20),
(2,10,1,599.99,0.07),
(2,10,2,599.99,0.05),
(3,3,1,999.99,0.05),
(3,10,1,599.99,0.05),
(4,2,2,749.99,0.10);

-- “Retrieve the first name, last name, and email of all customers.”
use bikestore;
select first_name,last_name,email
from customers;

-- 2) Returns the customers located in California (state is CA)
select *  from customers
where state ="CA";

-- 3) Sorts the customers by their first names in ascending order 

select * from customers
order by first_name;

-- 4) Returns all the cities of customers located in California and the number of customers 
-- in each city 
select city, count(customer_id)
from customers
where state ="CA"
group by city;

-- 5) Return the city in California which has more than ten customers 
select city, count(customer_id)as total_customer
from customers
where state ="CA"
group by city
having total_customer > 10;

-- 6) Retrieve the product name and model year from the "products" table where the list 
-- price is from 1000 to 2000 

select * from products;
select product_name,model_year 
from products
where list_price between 1000 and 2000;

-- 7) Retrieve the first name and email from the "staffs" table where the active status is 1 
select first_name, email 
from staffs
where active = 1;

-- 8) Retrieve the product name and brand ID from the "products" table where the model 
-- year is 2016 and the list price is greater than 1000 
select product_name,brand_id
 from products
 where model_year = 2016
 and list_price >= 1000;
--  9) Retrieve the order ID and customer ID from the "orders" table where the shipped date 
-- is not null 
 select order_id, customer_id from orders
 where shipped_date is not null;
 
--  10) Retrieve the product ID, list price and quantity from the "order_items" table where 
-- the discount is greater than 0 and quantity equal 2 
select product_id, list_price,quantity 
from order_items
where discount  > 0 and quantity =2;

-- 11) Find Stores with more than 5 Products in Stock and ordered by the number of 
-- products 

select store_id,count(product_id)as total_products
 from stocks
group by store_id
having total_products >= 10 
ORDER BY total_products;

-- 12) This query retrieves customers whose email address ends with "@yahoo.com" and 
-- orders the result by customer name 
 SELECT CONCAT(first_name, ' ', last_name) AS customer_name,email
 from customers
 where email like '%@yahoo.com'
 order by customer_name;
-- 13) This query calculates the average list price of products for each category and 
-- includes only categories with an average price greater than 500, ordered by the average 
-- price in descending order. 
 
 select *  from products;
  select *  from categories;
 
 select category_id, avg(list_price) as avg_price
 from products
 group by category_id
 having avg_price >= 500 
 order by avg_price desc;
 
--  14) This query counts the total number of products for each brand and includes only 
-- brands that have more than 2 products, ordering the result by the total number of 
-- products in descending order. 
 select *  from products;
  select *  from brands;
  
  select brand_id, count(product_id) as total_product
  from products
  group by brand_id
  having total_product > 2
  order by total_product desc;
  
 
 
 




