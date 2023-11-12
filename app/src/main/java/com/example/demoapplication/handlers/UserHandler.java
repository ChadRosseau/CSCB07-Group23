package com.example.demoapplication.handlers;

import com.example.demoapplication.handlers.subhandlers.AnnouncementsHandler;
import com.example.demoapplication.handlers.subhandlers.ComplaintsHandler;
import com.example.demoapplication.handlers.subhandlers.EventsHandler;
import com.google.firebase.database.FirebaseDatabase;

public abstract class UserHandler {
    protected FirebaseDatabase db;
    AnnouncementsHandler announcements;
    ComplaintsHandler complaints;
    EventsHandler events;

    public UserHandler(FirebaseDatabase db) {
        this.db = db;
    }
}
