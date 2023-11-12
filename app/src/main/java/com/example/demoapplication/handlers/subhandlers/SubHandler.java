package com.example.demoapplication.handlers.subhandlers;

import com.example.demoapplication.handlers.contracts.ListenerTracker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class SubHandler {
    protected FirebaseDatabase db;
    protected DatabaseReference root;
    protected ListenerTracker listenerTracker;

    public SubHandler(FirebaseDatabase db) {
        this.db = db;
        this.listenerTracker = new ListenerTracker();
    }

}
