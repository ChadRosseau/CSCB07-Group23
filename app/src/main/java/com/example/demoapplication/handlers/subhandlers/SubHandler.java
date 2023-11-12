package com.example.demoapplication.handlers.subhandlers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class SubHandler {
    protected FirebaseDatabase db;
    protected DatabaseReference root;

    public SubHandler(FirebaseDatabase db) {
        this.db = db;
    }

}
