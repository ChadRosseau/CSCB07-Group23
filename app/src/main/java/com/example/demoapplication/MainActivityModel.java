package com.example.demoapplication;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.BaseClass;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.baseClasses.ListenerCallback;
import com.example.demoapplication.presenters.contracts.ListenerTracker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivityModel {
    static MainActivityModel instance;
    FirebaseDatabase db;

    private MainActivityModel(){
        db = FirebaseDatabase.getInstance("https://cscb07-group23-default-rtdb.firebaseio.com");
    }

    public static MainActivityModel getInstance() {
        if (instance == null) instance = new MainActivityModel();
        return instance;
    }

    public DatabaseReference getRootRef() {return db.getReference();}

    public DatabaseReference createChildRef(DatabaseReference ref) {
        return ref.push();
    }

    // Used to add and manage listener on a database node.
    public <T extends BaseClass> void createSubscription(DatabaseReference target, ListenerTracker tracker, Class<T> cls, ListenerCallback<T> callback) {
        // Create callback function
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Handle null case
                if (!snapshot.exists()) {
                    // Logic for non-existent event / error handling.
                    return;
                }
                // Handle single item case
                if (callback instanceof ItemListenerCallback) {
                    // Execute callback with obj of type T
                    T obj = snapshot.getValue(cls);
                    ((ItemListenerCallback<T>)callback).execute(obj);
                }
                // Handle array case
                else if (callback instanceof ArrayListenerCallback) {
                    // Create and populate list using snapshot
                    ArrayList<T> objList = new ArrayList<>();
                    for (@NonNull DataSnapshot objSnapshot : snapshot.getChildren()){
                        objList.add(objSnapshot.getValue(cls));
                    }
                    // Execute callback with list of obj of type T
                    ((ArrayListenerCallback<T>)callback).execute(objList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        };

        // Track listener to remove when finished.
        tracker.addListener(target, listener);
    }

    // Used to add and manage listener on a child node of a database node.
    public <T extends BaseClass> void createSubscriptionOnChild(DatabaseReference parentRef, String childKey, ListenerTracker tracker, Class<T> cls, ListenerCallback<T> callback) {
        this.createSubscription(parentRef.child(childKey), tracker, cls, callback);
    }

    // Used to set the data at a given reference in the database.
    public <T> void setRef(DatabaseReference target, T obj) {
        target.setValue(obj);
    }


}
