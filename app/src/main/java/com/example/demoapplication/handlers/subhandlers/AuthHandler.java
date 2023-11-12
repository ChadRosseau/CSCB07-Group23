package com.example.demoapplication.handlers.subhandlers;

import com.example.demoapplication.handlers.UserHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AuthHandler extends SubHandler {

    public AuthHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db);
        this.root = ref.child("auth");
    }
}
