package com.example.demoapplication.fragments;
import java.util.ArrayList;
public class EventConstants {
    public static ArrayList<Event> getEventData(){
        ArrayList<Event> eventArrayList = new ArrayList<Event>();
        Event event1 = new Event("LAUNCH", "08/20/2023", "500", "200", "A day for you to talk to employers directly!");
        eventArrayList.add(event1);

        Event event2 = new Event("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event2);

        Event event3 = new Event("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event3);

        Event event4 = new Event("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event4);
        Event event5 = new Event("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event5);
        Event event6 = new Event("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event6);
        Event event7 = new Event("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event7);


        return eventArrayList;
    }
}
