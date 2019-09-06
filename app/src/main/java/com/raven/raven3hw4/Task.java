package com.raven.raven3hw4;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {
    public String title;
    public String description;
    public Date startDate;
    public Date endDate;
    public boolean isDone;

    public Task(String title, String description, Date startDate, Date endDate, boolean isDone) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isDone = isDone;
    }



    public String dates(){
        String startDateStr = dateToString(startDate);
        String endDateStr = dateToString(endDate);
        return startDateStr + " - " + endDateStr;
    }

    public String startDateStr(){
        return dateToString(startDate);
    }
    public String endDateStr(){
        return dateToString(endDate);
    }

    private String dateToString(Date date){
        DateFormat format = new SimpleDateFormat();
        String string = format.format(date);
        return string;
    }
}
