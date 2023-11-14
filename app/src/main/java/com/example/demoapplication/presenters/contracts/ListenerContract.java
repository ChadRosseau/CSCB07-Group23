package com.example.demoapplication.presenters.contracts;

import com.google.firebase.database.DatabaseReference;

public abstract class ListenerContract {
    DatabaseReference target;
    Listener listener;
}
