package com.example.demoapplication.fragments.events;
import com.example.demoapplication.baseClasses.Event;

import java.util.ArrayList;
public class EventConstants {
    public static ArrayList<Event> getEventData(){
        ArrayList<Event> eventArrayList = new ArrayList<Event>();
        Event event1 = new Event("A", "LAUNCH", "A day for you to talk to employers directly!", 200, 300, 1701145922);
        eventArrayList.add(event1);

        Event event2 = new Event("A", "Office Hours", "Are you failing all your courses? Seek some help!", 100, 200, 1701145922);
        eventArrayList.add(event2);

        Event event3 = new Event("A", "Office Hours", "Are you failing all your courses? Seek some help!", 100, 200, 1701145922);
        eventArrayList.add(event3);

        Event event4 = new Event("A", "Office Hours", "Are you failing all your courses? Seek some help!", 100, 200, 1701145922);
        eventArrayList.add(event4);
        Event event5 = new Event("A", "Office Hours", "Are you failing all your courses? Seek some help!", 100, 200, 1701145922);
        eventArrayList.add(event5);
        Event event6 = new Event("A", "Office Hours", "Are you failing all your courses? Seek some help!", 100, 200, 1701145922);
        eventArrayList.add(event6);
        Event event7 = new Event("A", "Office Hours", "Are you failing all your courses? Seek some help!", 100, 200, 1701145922);
        eventArrayList.add(event7);


        return eventArrayList;
    }
}
