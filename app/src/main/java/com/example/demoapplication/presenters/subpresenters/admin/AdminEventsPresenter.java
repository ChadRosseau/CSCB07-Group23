package com.example.demoapplication.presenters.subpresenters.admin;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;
import com.google.firebase.database.DatabaseReference;

import java.util.Date;

public class AdminEventsPresenter extends EventsPresenter {

    public AdminEventsPresenter(MainActivityView view) {
        super(view);
    }

    public Event createEvent(String title, String description, int maxAttendees, Date date, String location) {
        // Generate a unique DB reference for new object.
        DatabaseReference target = model.createChildRef(Event.parentRef);
        // Retrieve key from new reference.
        String eventId = target.getKey();
        // Generate timestamp for event.
        // long date = Helper.createTimestamp();
        long unixDate = date.getTime() / 1000;
        // Create new event object using combination of parameters and generated data.
        Event newEvent = new Event(eventId, title, description, 0, maxAttendees, unixDate, location);
        // Set target DB ref to new object.
        model.setRef(target, newEvent);

        return newEvent;
    }

    public void getEventFeedback(AdminEventsPresenter presenter, String eventId) {
        // Define custom callback
        ItemListenerCallback<Feedback> callback = new ItemListenerCallback<Feedback>() {
            public void execute(Feedback feedback) {
                System.out.println(feedback);
            }
        };
        model.createSubscriptionOnChild(Feedback.parentRef, eventId, this.listenerTracker, Feedback.class, callback);
    }
}
