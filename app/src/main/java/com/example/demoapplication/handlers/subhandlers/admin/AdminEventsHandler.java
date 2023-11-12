package com.example.demoapplication.handlers.subhandlers.admin;

import com.example.demoapplication.base_classes.Event;
import com.example.demoapplication.handlers.subhandlers.EventsHandler;
import com.example.demoapplication.helpers.Helper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;

public class AdminEventsHandler extends EventsHandler {

    public AdminEventsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

    Event createEvent(String title, String description, int attendeeCount) {
        // Generate a unique DB reference for new object.
        DatabaseReference target = root.child("eventList").push();
        // Retrieve key from new reference.
        String eventId = target.getKey();
        // Generate timestamp for event.
        long date = Helper.createTimestamp();
        // Create new event object using combination of parameters and generated data.
        Event newEvent = new Event(eventId, title, description, attendeeCount, date);
        // Set target DB ref to new object.
        target.setValue(newEvent);

        return newEvent;
    }




}