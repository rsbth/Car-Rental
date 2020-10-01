package com.santosh.Model;

import com.santosh.Booking;
import com.santosh.ReportByHour;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.List;

public class BookingModel {
    private List<Booking> bookings = new ArrayList<Booking>();;
    private String jdbc_database = "jdbc:mysql://localhost:3306/app";
    private String jdbc_username = "root";
    private String jdbc_password = "tiger";


    public List<Booking> getAllBookings() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from bookings");
            while (results.next()) {
                Booking booking = new Booking();
                booking.setBookingId(results.getInt("bookingid"));
                booking.setUserid(results.getString("userid"));
                booking.setPlateNumber(results.getString("platenumber"));
                booking.setFrom(results.getDate("fromdate"));
                booking.setTo(results.getDate("todate"));
                bookings.add(booking);
            }
            return bookings;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Booking getBooking(String bookingId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from bookings where bookingid ='"+bookingId+"'");
            if (results.next()) {
                Booking booking = new Booking();
                booking.setBookingId(results.getInt("bookingid"));
                booking.setUserid(results.getString("userid"));
                booking.setPlateNumber(results.getString("platenumber"));
                booking.setFrom(results.getDate("fromdate"));
                booking.setTo(results.getDate("todate"));
                return booking;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Booking> getBookingByDate(String fromDate, String toDate) {
        try {
            List<Booking> bookings = new ArrayList<Booking>();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from bookings where fromDate between '"+fromDate+"' and '"+toDate+"'");
            while (results.next()) {
                Booking booking = new Booking();
                booking.setBookingId(results.getInt("bookingid"));
                booking.setUserid(results.getString("userid"));
                booking.setPlateNumber(results.getString("platenumber"));
                booking.setFrom(results.getDate("fromdate"));
                booking.setTo(results.getDate("todate"));
                bookings.add(booking);
            }
            return bookings;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ReportByHour getReportData(String fromDate, String toDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from bookings b INNER JOIN cars c USING(platenumber) where b.fromDate between '"+fromDate+"' and '"+toDate+"'");
         //   int count=0;
            int total_payment = 0;
            long total_time = 0;
            while (results.next()) {
                Date to_date = results.getDate("todate");
                Date from_date = results.getDate("fromdate");
                long diff = to_date.getTime() - from_date.getTime() ;
                total_time +=  diff;
                total_payment+=results.getInt("cost");
            //    count++;
            }
            long number_of_hours = total_time / 3600000;
            ReportByHour report = new ReportByHour();
            report.setNo_of_hours(number_of_hours);
            report.setPayments(total_payment * number_of_hours);
            return report;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addBooking(String lisencePlate, String userid, Date from, Date to){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbc_database, jdbc_username, jdbc_password);
            PreparedStatement statement = connection.prepareStatement("insert into bookings (userid,platenumber,fromdate,todate) values(?,?,?,?)");
            statement.setString(1, userid);
            statement.setString(2, lisencePlate);
            statement.setDate(3, new java.sql.Date(from.getTime()) );
            statement.setDate(4, new java.sql.Date(to.getTime()));
            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
