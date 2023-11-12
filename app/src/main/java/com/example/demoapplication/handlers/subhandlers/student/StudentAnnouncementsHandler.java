package com.example.demoapplication.handlers.subhandlers.student;

import com.example.demoapplication.handlers.subhandlers.AnnouncementsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentAnnouncementsHandler extends AnnouncementsHandler {

    public StudentAnnouncementsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }
}
