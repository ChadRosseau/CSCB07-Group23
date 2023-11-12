package com.example.demoapplication.handlers.subhandlers.admin;

import com.example.demoapplication.handlers.subhandlers.ComplaintsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminComplaintsHandler extends ComplaintsHandler {
    public AdminComplaintsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }
}
