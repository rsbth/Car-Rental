package com.santosh.Model;

import com.santosh.Booking;
import com.santosh.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CarModel {
    private List<Car> cars = new ArrayList<Car>();;
    private String jdbc_database = "jdbc:mysql://192.168.99.100:3306/app";
    private String jdbc_username = "root";
    private String jdbc_password = "tiger";


    public List<Car> getAllCars() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from cars");
            while (results.next()) {
                Car car = new Car();
                car.setModel(results.getString("carname"));
                car.setPlateNumber(results.getString("platenumber"));
                car.setPrice(results.getInt("cost"));
                car.setFrom(results.getDate("fromavailable"));
                car.setTo(results.getDate("toavailable"));
                cars.add(car);
            }
            return cars;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Car getCar(String plateNumber) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from cars where platenumber ='"+plateNumber+"'");
            if (results.next()) {
                Car car = new Car();
                car.setModel(results.getString("carname"));
                car.setPlateNumber(results.getString("platenumber"));
                car.setPrice(results.getInt("cost"));
                return car;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addCar(String lisencePlate, String model, int price, Date from, Date to){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            PreparedStatement statement = connection.prepareStatement("insert into cars values(?,?,?, ?,?)");
            statement.setString(1, lisencePlate);
            statement.setString(2,model);
            statement.setInt(3,price);
            statement.setDate(4, new java.sql.Date(from.getTime()));
            statement.setDate(5, new java.sql.Date(to.getTime()));
            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
