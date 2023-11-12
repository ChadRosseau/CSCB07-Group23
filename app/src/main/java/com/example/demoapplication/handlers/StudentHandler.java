package com.example.demoapplication.handlers;

import com.example.demoapplication.handlers.subhandlers.student.StudentAnnouncementsHandler;
import com.example.demoapplication.handlers.subhandlers.student.StudentComplaintsHandler;
import com.example.demoapplication.handlers.subhandlers.student.StudentEventsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentHandler extends UserHandler {
    FirebaseDatabase db;
    StudentAnnouncementsHandler announcements;
    StudentComplaintsHandler complaints;
    StudentEventsHandler events;
    public StudentHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db);
        this.announcements = new StudentAnnouncementsHandler(db, ref);
        this.complaints = new StudentComplaintsHandler(db, ref);
        this.events = new StudentEventsHandler(db, ref);
    }
}
