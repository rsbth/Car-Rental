package com.santosh;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReportByHour {
    private int no_of_hours;
    private int payments;

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    public int getNo_of_hours() {
        return no_of_hours;
    }

    public void setNo_of_hours(int no_of_hours) {
        this.no_of_hours = no_of_hours;
    }
}
