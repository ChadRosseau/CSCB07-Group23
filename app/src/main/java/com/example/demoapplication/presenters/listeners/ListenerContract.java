package com.example.demoapplication.presenters.listeners;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public abstract class ListenerContract {
    DatabaseReference target;
    ValueEventListener listener;
}
