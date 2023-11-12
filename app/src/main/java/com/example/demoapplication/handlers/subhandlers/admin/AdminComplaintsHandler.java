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

public class AdminComplaintsHandler extends ComplaintsHandler {
    public AdminComplaintsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }



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

        this.listenerTracker.addListener(target, listener);
    }
}
