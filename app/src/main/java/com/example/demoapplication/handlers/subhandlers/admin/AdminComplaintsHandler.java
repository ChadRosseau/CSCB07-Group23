package com.example.demoapplication.handlers.subhandlers.admin;

import androidx.annotation.NonNull;

import com.example.demoapplication.MainActivityPresenter;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.handlers.subhandlers.ComplaintsHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Handles complaints for the admin.
 * Extends the ComplaintsHandler class.
 */
public class AdminComplaintsHandler extends ComplaintsHandler {
    /**
     * Constructor for AdminComplaintsHandler.
     *
     * @param db  The Firebase database instance.
     * @param ref The database reference.
     */
    public AdminComplaintsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

    /**
     * Retrieves complaints from the Firebase Realtime Database.
     */
    public void getComplaints(){
        DatabaseReference target = root.child("complaints");

        ValueEventListener listener = new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<Complaint> complaints = new ArrayList<>();
                for (@NonNull DataSnapshot complaintSnapshot : snapshot.getChildren()){
                    complaints.add(complaintSnapshot.getValue(Complaint.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }
        };
        /**
         * Adds a listener to the complaints node in the database.
         */
        this.listenerTracker.addListener(target, listener);
    }
}
