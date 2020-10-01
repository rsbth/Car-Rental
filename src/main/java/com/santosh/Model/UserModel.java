package com.santosh.Model;

import com.santosh.Booking;
import com.santosh.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> users = new ArrayList<User>();;
    private String jdbc_database = "jdbc:mysql://localhost:3306/app";
    private String jdbc_username = "root";
    private String jdbc_password = "tiger";


    public List<User> getAllUsers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from users");
            while (results.next()) {
                User user = new User();
                user.setUserid(results.getString("userid"));
                user.setName(results.getString("username"));
                users.add(user);
            }
            return users;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public User getUser(String userid) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from users where userid ='"+userid+"'");
            if (results.next()) {
                User user = new User();
                user.setUserid(results.getString("userid"));
                user.setName(results.getString("username"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(String userid, String username){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            PreparedStatement statement = connection.prepareStatement("insert into users values(?,?)");
            statement.setString(1, userid);
            statement.setString(2, username);
            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
