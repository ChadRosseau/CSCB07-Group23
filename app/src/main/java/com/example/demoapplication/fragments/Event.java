package com.example.demoapplication.fragments;

import java.io.Serializable;

public class Event implements Serializable {
    private String name; // event name
    private String date;

    private String maxParticipants;

    private String remaining;
    private String description;
//    private String feedback;

    public Event(String name, String date, String maxParticipants, String remaining, String description){
        this.name = name;
        this.date = date;
        this.maxParticipants = maxParticipants;
        this.remaining = remaining;
        this.description = description;
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
    public String getMaxParticipants(){return maxParticipants;}
    public String getRemaining(){return remaining;}
}
