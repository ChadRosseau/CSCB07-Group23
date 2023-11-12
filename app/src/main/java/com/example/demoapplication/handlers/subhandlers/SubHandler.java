package com.example.demoapplication.handlers.subhandlers;

import androidx.annotation.NonNull;

import com.example.demoapplication.baseClasses.ListenerCallback;
import com.example.demoapplication.handlers.contracts.ListenerTracker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public abstract class SubHandler {
    protected FirebaseDatabase db;
    protected DatabaseReference root;
    protected ListenerTracker listenerTracker;

    public SubHandler(FirebaseDatabase db) {
        this.db = db;
        this.listenerTracker = new ListenerTracker();
    }

    // Generates and manages a listener given a target and a callback function.
    // 2nd parameter is necessary to prevent type erasure issues.
    public <T> void createSubscription(DatabaseReference target, Class<T> cls, ListenerCallback<T> callback) {
        // Create callback function
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    System.err.println("Event does not exist");
                    // Logic for non-existent event / error handling.
                    // presenter.setViewText("Event does not exist");
                }
                T obj = snapshot.getValue(cls);
                callback.execute(obj);
                // Logic for what to do with Feedback object, such as call Presenter methods.
                // presenter.setViewText("Event exists");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        };

        // Track listener to remove when finished.
        this.listenerTracker.addListener(target, listener);
    }
}
