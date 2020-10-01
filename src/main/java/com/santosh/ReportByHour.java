package com.santosh;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReportByHour {
    private long no_of_hours;
    private int payments;

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    public long getNo_of_hours() {
        return no_of_hours;
    }

    public void setNo_of_hours(long no_of_hours) {
        this.no_of_hours = no_of_hours;
    }
}
