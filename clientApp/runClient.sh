#!bin/bash

echo "Registering 5 cars ......"
#create 5 cars

curl -X POST -H "Content-Type: application/xml" -d @./cars/car1.xml http://localhost:8080/app/api/cars/addCar
curl -X POST -H "Content-Type: application/xml" -d @./cars/car2.xml http://localhost:8080/app/api/cars/addCar
curl -X POST -H "Content-Type: application/xml" -d @./cars/car3.xml http://localhost:8080/app/api/cars/addCar
curl -X POST -H "Content-Type: application/xml" -d @./cars/car4.xml http://localhost:8080/app/api/cars/addCar
curl -X POST -H "Content-Type: application/xml" -d @./cars/car5.xml http://localhost:8080/app/api/cars/addCar

echo "Registering 10 users ....."
#create 10 users
curl -X POST -H "Content-Type: application/xml" -d @./users/user1.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user2.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user3.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user4.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user5.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user6.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user7.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user8.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user9.xml http://192.168.99.100:8080/app/api/users/addUser
curl -X POST -H "Content-Type: application/xml" -d @./users/user10.xml http://192.168.99.100:8080/app/api/users/addUser

