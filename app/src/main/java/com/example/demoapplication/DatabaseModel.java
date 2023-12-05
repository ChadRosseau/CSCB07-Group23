package com.example.demoapplication;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.demoapplication.presenters.listeners.ArrayListenerCallback;
import com.example.demoapplication.presenters.listeners.ItemListenerCallback;
import com.example.demoapplication.presenters.listeners.ListenerTracker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseModel {
    static DatabaseModel instance;
    FirebaseDatabase db;

    private DatabaseModel(){
        db = FirebaseDatabase.getInstance("https://cscb07-group23-default-rtdb.firebaseio.com");
    }

    public static DatabaseModel getInstance() {
        if (instance == null) instance = new DatabaseModel();
        return instance;
    }

    public DatabaseReference getRootRef() {return db.getReference();}

    public DatabaseReference createChildRef(DatabaseReference ref) {
        return ref.push();
    }

    // Used to add and manage listener on a single item.
    public <T> void createSubscription(DatabaseReference target, ListenerTracker tracker, Class<T> cls, ItemListenerCallback<T> callback) {
        // Create callback function
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    // Handle null case
                    if (!snapshot.exists()) {
                        // Logic for non-existent event / error handling.
                        Log.d("MODEL", "snapshot not found");
                        return;
                    }
                    // Execute callback with obj of type T
                    T obj = snapshot.getValue(cls);
                    ((ItemListenerCallback<T>)callback).execute(obj);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
                Log.d("MODEL", "createSubscription cancelled");
            }
        };

        // Track listener to remove when finished.
        tracker.addListener(target, listener);
    }

    // Used to add and manage listener on a single item.
    public <T> void createSubscriptionOnArray(Query target, ListenerTracker tracker, Class<T> cls, ArrayListenerCallback<T> callback) {
        // Create callback function
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Create and populate list using snapshot
                ArrayList<T> objList = new ArrayList<>();
                if (snapshot.exists()) {
                    for (@NonNull DataSnapshot objSnapshot : snapshot.getChildren()) {
                        objList.add(objSnapshot.getValue(cls));
                    }
                }
                // Execute callback with list of obj of type T
                ((ArrayListenerCallback<T>)callback).execute(objList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
                Log.d("MODEL", "createSubscriptionOnArray cancelled");
            }
        };

        // Track listener to remove when finished.
        tracker.addListener(target, listener);
    }



    public <T> void createSubscriptionOnMap(DatabaseReference target, ListenerTracker tracker, Class<T> valCls, ItemListenerCallback<Map<String,T>> callback) {
        // Create callback function
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, T> map = new HashMap<>();
                if (snapshot.exists()) {
                    for (DataSnapshot valSnapshot: snapshot.getChildren()) {
                        T val = valSnapshot.getValue(valCls);
                        map.put(valSnapshot.getKey(), val);
                    }
                }
                callback.execute(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
                Log.d("MODEL", "createSubscriptionOnMap cancelled");
            }
        };
        // Track listener to remove when finished.
        tracker.addListener(target, listener);
    }

    public void runTransaction(DatabaseReference target, Transaction.Handler handler) {
        target.runTransaction(handler);
    }

    // Used to set the data at a given reference in the database.
    public <T> void setRef(DatabaseReference target, T obj) { target.setValue(obj); }

    // Used to remove the data at a given reference in the database.
    public void deleteRef(DatabaseReference target) {
        target.removeValue();
    }


}
