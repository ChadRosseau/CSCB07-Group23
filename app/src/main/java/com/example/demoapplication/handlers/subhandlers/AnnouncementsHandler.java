package com.example.demoapplication.handlers.subhandlers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class AnnouncementsHandler extends SubHandler {

    public AnnouncementsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db);
        this.root = ref.child("announcements");
    }
}
