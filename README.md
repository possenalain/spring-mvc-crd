# spring-mvc-crd
spring mvc -  thymeleaf- crud ops


In this small project, there will be an implementation **mvc** model and use **thymeleaf** to create a java application 
with basic crud operations.

* Create, 
* read, 
* update and 
* delete   

** H2 in memory database is used, but any other datasource of choice could work as fine.
```
create table Cart (
id integer not null,
dateCreated timestamp,
dateUpdated timestamp,
version integer,
user_id integer,
primary key (id))
```
```
create table CartDetail (
id integer not null,
dateCreated timestamp,
dateUpdated timestamp,
version integer,
quantity integer,
cart_id integer,
product_id integer,
primary key (id))
```
```
create table Customer (
id integer not null,
dateCreated timestamp,
dateUpdated timestamp,
version integer,
billingAddress_addressLineOne varchar(255),
billingAddress_addressLineTwo varchar(255),
billingAddress_city varchar(255),
billingAddress_state varchar(255),
billingAddress_zipCode varchar(255),
email varchar(255),
firstName varchar(255),
lastName varchar(255),
phoneNumber varchar(255),
shippingAddress_addressLineOne varchar(255),
shippingAddress_addressLineTwo varchar(255),
shippingAddress_city varchar(255),
shippingAddress_state varchar(255),
shippingAddress_zipCode varchar(255),
user_id integer, primary key (id))
```
```
create table OrderDetail (
id integer not null,
dateCreated timestamp,
dateUpdated timestamp,
version integer,
quantity integer,
order_id integer,
product_id integer,
primary key (id))
```
```
create table Orders (
id integer not null,
dateCreated timestamp,
dateUpdated timestamp,
version integer,
dateShipped timestamp,
shipToAddress_addressLineOne varchar(255),
shipToAddress_addressLineTwo varchar(255),
shipToAddress_city varchar(255),
shipToAddress_state varchar(255),
shipToAddress_zipCode varchar(255),
status integer,
customer_id integer,
primary key (id))
```
```
create table Product (
id integer not null,
dateCreated timestamp,
dateUpdated timestamp,
version integer,
description varchar(255),
imageUrl varchar(255),
price numeric(19,2), primary key (id))
```
```
create table Users (
id integer not null,
dateCreated timestamp,
dateUpdated timestamp,
version integer,
enabled boolean,
encryptedPassword varchar(255),
username varchar(255),
cart_id integer,
customer_id integer,
primary key (id))
```
