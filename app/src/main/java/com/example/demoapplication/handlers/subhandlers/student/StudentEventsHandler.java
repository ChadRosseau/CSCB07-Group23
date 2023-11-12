package com.example.demoapplication.handlers.subhandlers.student;

import androidx.annotation.NonNull;

import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.handlers.subhandlers.EventsHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Handles events for the student.
 * Extends the EventsHandler class.
 */
public class StudentEventsHandler extends EventsHandler {
    /**
     * Constructor for StudentEventsHandler.
     *
     * @param db  The Firebase database instance.
     * @param ref The database reference.
     */
    public StudentEventsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

    /**
     * Retrieves a list of scheduled events from the Firebase Realtime Database.
     */

}
