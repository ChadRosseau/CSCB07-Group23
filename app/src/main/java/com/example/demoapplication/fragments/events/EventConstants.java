package com.example.demoapplication.fragments.events;
import java.util.ArrayList;
public class EventConstants {
    public static ArrayList<EventItem> getEventData(){
        ArrayList<EventItem> eventArrayList = new ArrayList<EventItem>();
        EventItem event1 = new EventItem("LAUNCH", "08/20/2023", "500", "200", "A day for you to talk to employers directly!");
        eventArrayList.add(event1);

        EventItem event2 = new EventItem("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event2);

        EventItem event3 = new EventItem("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event3);

        EventItem event4 = new EventItem("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event4);
        EventItem event5 = new EventItem("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event5);
        EventItem event6 = new EventItem("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event6);
        EventItem event7 = new EventItem("Office Hours", "10/24/2023", "300", "100", "Are you failing all your courses? Seek some help!");
        eventArrayList.add(event7);


        return eventArrayList;
    }
}
