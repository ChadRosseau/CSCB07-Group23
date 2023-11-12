package com.example.demoapplication.handlers.subhandlers.admin;

import com.example.demoapplication.base_classes.Event;
import com.example.demoapplication.handlers.subhandlers.EventsHandler;
import com.example.demoapplication.handlers.subhandlers.SubHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;

public class AdminEventsHandler extends EventsHandler {

    public AdminEventsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

}
