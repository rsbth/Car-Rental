# Car Rental REST Application

How to run this application

With Docker:
1.mvn clean install.
2.docker build . -t image_name:version.
3.docker run -d -p 8080:8080 image_name:version.

Locally with tomcat:
1.mvn clean install.
2.Copy app.war in target directory to webapps folder of tomat.
3.Start tomcat server.

With Docker-compose:
1.mvn clean install.
2.docker-compose up .


Database Requirements:
MySQL 8 is needed. 

docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=tiger mysql:8



Creating Database and Tables: 

1.docker exec -it <my_sql_container_id/name> /bin/bash

Shell-script setupdb.sh can be used for this purpose or manual instructions below.

Logging into mysql:
mysql -uroot -ptiger

Creating Database: 
1.create database app;
2.use app;

Bookings Table:
create table bookings(bookingid int NOT NULL AUTO_INCREMENT, userid varchar(20), platenumber varchar(20), fromdate date, todate date, PRIMARY KEY (bookingid));

Cars Table:
create table cars(platenumber varchar(20), carname varchar(20), cost int, fromavailable date, toavailable date);

Users Table:
create table users(userid varchar(20), username varchar(20));

Screenshots of working application:
