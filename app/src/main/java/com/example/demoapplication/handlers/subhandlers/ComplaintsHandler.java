package com.example.demoapplication.handlers.subhandlers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class ComplaintsHandler extends SubHandler {
    public ComplaintsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db);
        this.root = ref.child("complaints");
    }
}
