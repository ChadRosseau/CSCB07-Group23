package com.example.demoapplication.handlers.contracts;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public abstract class ListenerContract {
    DatabaseReference target;
    Listener listener;
}
