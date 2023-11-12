package com.example.demoapplication.handlers.subhandlers.admin;

import com.example.demoapplication.handlers.subhandlers.AnnouncementsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminAnnouncementsHandler extends AnnouncementsHandler {

    public AdminAnnouncementsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }
}
