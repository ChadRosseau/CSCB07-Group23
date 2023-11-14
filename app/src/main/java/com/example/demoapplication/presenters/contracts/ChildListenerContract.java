package com.example.demoapplication.presenters.contracts;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;

public class ChildListenerContract extends ListenerContract {
    ChildEventListener listener;

    public ChildListenerContract(DatabaseReference target, ChildEventListener listener) {
        this.target = target;
        this.listener = listener;
    }
}
