package com.santosh.Controller;

import com.santosh.Car;
import com.santosh.Model.CarModel;
import com.santosh.Model.UserModel;
import com.santosh.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("users")
public class UserController {
    private List<User> list_of_users = new ArrayList<User>();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUser(){
        return new UserModel().getAllUsers();
    }

    @GET
    @Path("user/{param}")
    @Produces(MediaType.APPLICATION_XML)
    public User getCarById(@PathParam("param") String userid){
        return new UserModel().getUser(userid);
    }

    @POST
    @Path("addUser")
    public User addUser(User u){
        System.out.println("Logging ..."+ u.getName() + " "+ u.getUserid());
        UserModel userModel = new UserModel();
        userModel.addUser(u.getUserid(), u.getName());
        list_of_users.add(u);
        return u;
    }
}
