package com.santosh.Controller;

import com.santosh.Booking;
import com.santosh.Model.BookingModel;
import com.santosh.ReportByHour;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("bookings")
public class BookingController {
    private List<Booking> list_of_bookings = new ArrayList<Booking>();
    DateTimeFormatter format =  DateTimeFormatter.ofPattern("YYYY-MM-DD");

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Booking> getBookings(){
        return new BookingModel().getAllBookings();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("booking/{param}")
    public Booking getBookingById(@PathParam("param") String bookingId){
        return new BookingModel().getBooking(bookingId);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("reporthours")
    public ReportByHour getreport(@QueryParam("from_date") String fromDate, @QueryParam("to_date") String toDate){
    return  new BookingModel().getReportData(fromDate, toDate);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("filterbydate")
    public List<Booking> getBookingByDate(@QueryParam("from_date") String fromDate, @QueryParam("to_date") String toDate){
        return new BookingModel().getBookingByDate(fromDate, toDate);
    }

    @POST
    @Path("addBooking")
    public Booking addBooking(Booking b){
        System.out.println("Logging ...");
        BookingModel bookingModel = new BookingModel();
        bookingModel.addBooking(b.getPlateNumber(), b.getUserid(), b.getFrom(), b.getTo());
        list_of_bookings.add(b);
        return b;
    }
}
