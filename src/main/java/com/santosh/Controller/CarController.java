package com.santosh.Controller;

import com.santosh.Car;
import com.santosh.Model.CarModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("cars")
public class CarController {
    private List<Car> list_of_cars = new ArrayList<Car>();
   // SimpleDateFormat format =  new SimpleDateFormat("YYYY-MM-DD");

    /*    Car c1 = new Car();
        c1.setPlateNumber("AAEUSWE123");
        c1.setPrice(300);
        c1.setModel("Volvo X60");
        list_of_cars.add(c1); */

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Car> getCar(){
        return new CarModel().getAllCars();
    }

    @GET
    @Path("car/{param}")
    @Produces(MediaType.APPLICATION_XML)
    public Car getCarById(@PathParam("param") String carName){
        return new CarModel().getCar(carName);
    }

    @POST
    @Path("addCar")
    public Car addCar(Car c){
        System.out.println("Logging ..."+ c.getPlateNumber()+" "+c.getModel()+" "+c.getPrice());
        CarModel carModel = new CarModel();
        carModel.addCar(c.getPlateNumber(), c.getModel(), c.getPrice(), c.getFrom(), c.getTo());
        list_of_cars.add(c);
        return c;
    }
}
