package com.example.demoapplication.presenters.contracts;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ValueListenerContract extends ListenerContract {
    ValueEventListener listener;

    public ValueListenerContract(DatabaseReference target, ValueEventListener listener) {
        this.target = target;
        this.listener = listener;
    }
}
