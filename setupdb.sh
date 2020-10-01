#!/bin/bash

mysql -uroot -ptiger <<MYSQL_SCRIPT
create database app;
use app;
create table bookings(bookingid int NOT NULL AUTO_INCREMENT, userid varchar(20), platenumber varchar(20), fromdate date, todate date, PRIMARY KEY (bookingid));
create table cars(platenumber varchar(20), carname varchar(20), cost int, fromavailable date, toavailable date);
create table users(userid varchar(20), username varchar(20));

MYSQL_SCRIPT

echo "MySQL Database App created."
echo "Booking table created"
echo "Cars table created"
echo "Users table created"