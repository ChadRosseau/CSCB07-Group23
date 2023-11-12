package com.example.demoapplication.handlers.subhandlers.admin;

import androidx.annotation.NonNull;

import com.example.demoapplication.MainActivityPresenter;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.handlers.subhandlers.EventsHandler;
import com.example.demoapplication.helpers.Helper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.EventListener;

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
        // Create callback function
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    System.out.println("Event does not exist");
                    // Logic for non-existent event / error handling.
                    // presenter.setViewText("Event does not exist");
                }
                Feedback feedback = snapshot.getValue(Feedback.class);
                // Logic for what to do with Feedback object, such as call Presenter methods.
                // presenter.setViewText("Event exists");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        };

        // Track listener to remove when finished.
        this.listenerTracker.addListener(target, listener);
    }
}
