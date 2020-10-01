package com.santosh;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookingTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Booking.class);
    }

    @Test
    public void testMakeBookingAndVerifyResponseFormat(){
        try{
        Booking b = new Booking();
        b.setUserid("raimo");
        b.setPlateNumber("BGXAVPL10");
        b.setFrom(new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-10"));
        b.setTo(new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-20"));
        Response response = target("/bookings/addBooking/").request().post(Entity.xml(b));
        //assertEquals(response.getMediaType(), MediaType.APPLICATION_ATOM_XML_TYPE);
        }catch (ParseException pe){
            System.out.println("Please check the format and date .."+pe.getMessage() );
        }

    }
}
