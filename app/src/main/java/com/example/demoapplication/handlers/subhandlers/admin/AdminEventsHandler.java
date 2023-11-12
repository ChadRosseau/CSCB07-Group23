package com.example.demoapplication.handlers.subhandlers.admin;

import androidx.annotation.NonNull;

import com.example.demoapplication.MainActivityPresenter;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.baseClasses.ListenerCallback;
import com.example.demoapplication.handlers.subhandlers.EventsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class AdminEventsHandler extends EventsHandler {

    public AdminEventsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

    public Event createEvent(String title, String description, Date date) {
        // Generate a unique DB reference for new object.
        DatabaseReference target = root.child("eventList").push();
        // Retrieve key from new reference.
        String eventId = target.getKey();
        // Generate timestamp for event.
        // long date = Helper.createTimestamp();
        long unixDate = date.getTime() / 1000;
        // Create new event object using combination of parameters and generated data.
        Event newEvent = new Event(eventId, title, description, 0, unixDate);
        // Set target DB ref to new object.
        target.setValue(newEvent);

        return newEvent;
    }

    public void getEventFeedback(MainActivityPresenter presenter, String eventId) {
        // Generate target DBRef.
        DatabaseReference target = root.child("eventList").child(eventId);
        // Define custom callback
        ListenerCallback<Feedback> callback = new ListenerCallback<Feedback>() {
            public void execute(Feedback feedback) {
                System.out.println(feedback);
            }
        };
        this.createSubscription(target, Feedback.class, callback);
    }
}
