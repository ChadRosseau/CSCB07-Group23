package com.example.demoapplication.presenters.listeners;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ListenerContract {
    DatabaseReference target;
    ValueEventListener listener;

    public ListenerContract(DatabaseReference target, ValueEventListener listener) {
        this.target = target;
        this.listener = listener;
    }
}
