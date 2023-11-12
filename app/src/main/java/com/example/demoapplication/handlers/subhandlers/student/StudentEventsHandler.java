package com.example.demoapplication.handlers.subhandlers.student;

import com.example.demoapplication.handlers.subhandlers.EventsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentEventsHandler extends EventsHandler {
    public StudentEventsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }


}
