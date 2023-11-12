package com.example.demoapplication.handlers.contracts;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ValueListenerContract extends ListenerContract {
    ValueEventListener listener;

    public ValueListenerContract(DatabaseReference target, ValueEventListener listener) {
        this.target = target;
        this.listener = listener;
    }
}
