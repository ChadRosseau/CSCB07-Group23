package com.example.demoapplication.handlers.subhandlers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class EventsHandler extends SubHandler {

    public EventsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db);
        this.root = ref.child("events");
    }
}
