package com.santosh;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private String userid;
    private  String name;
    private int bookingNumber;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
