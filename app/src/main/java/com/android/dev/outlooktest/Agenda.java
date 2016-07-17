package com.android.dev.outlooktest;

import java.util.Date;

public class Agenda {

    private Date date;
    private String subject;
    private String address;

    public Agenda(Date date, String subject, String address) {
        this.date = date;
        this.subject = subject;
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
