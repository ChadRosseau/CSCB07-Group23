package com.example.demoapplication.handlers;

import com.example.demoapplication.handlers.subhandlers.SubHandler;
import com.example.demoapplication.handlers.subhandlers.admin.AdminAnnouncementsHandler;
import com.example.demoapplication.handlers.subhandlers.admin.AdminComplaintsHandler;
import com.example.demoapplication.handlers.subhandlers.admin.AdminEventsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminHandler extends SubHandler {
    FirebaseDatabase db;

    AdminAnnouncementsHandler announcements;
    AdminComplaintsHandler complaints;
    AdminEventsHandler events;

    public AdminHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db);
        this.announcements = new AdminAnnouncementsHandler(db, ref);
        this.complaints = new AdminComplaintsHandler(db, ref);
        this.events = new AdminEventsHandler(db, ref);
    }
}
