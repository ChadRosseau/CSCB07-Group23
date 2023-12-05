package com.example.demoapplication.presenters.listeners;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ListenerContract {
    Query target;
    ValueEventListener listener;

    public ListenerContract(Query target, ValueEventListener listener) {
        this.target = target;
        this.listener = listener;
    }
}
