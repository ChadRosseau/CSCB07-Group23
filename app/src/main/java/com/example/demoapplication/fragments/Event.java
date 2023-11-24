package com.example.demoapplication.fragments;

import java.io.Serializable;

public class Event implements Serializable {
    private String name; // event name
    private String date;
    private String description;
//    private String feedback;

    public Event(String name, String date, String description){
        this.name = name;
        this.date = date;
        this.description = description;
//        this.feedback = feedback;
    }
    public String getDate(){
        return date;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
//    public String getFeedback(){
//        return feedback;
//    }
}
