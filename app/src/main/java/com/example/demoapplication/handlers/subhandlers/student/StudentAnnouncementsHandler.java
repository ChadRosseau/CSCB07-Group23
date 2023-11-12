package com.example.demoapplication.handlers.subhandlers.student;

import androidx.annotation.NonNull;

import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.handlers.subhandlers.AnnouncementsHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles announcements for the student.
 * Extends the AnnouncementsHandler class.
 */
public class StudentAnnouncementsHandler extends AnnouncementsHandler {

    /**
     * Constructor for StudentAnnouncementsHandler.
     *
     * @param db  The Firebase database instance.
     * @param ref The database reference.
     */
    public StudentAnnouncementsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

    /**
     * Retrieves announcements from the Firebase Realtime Database.
     */
    public void getAnnouncements(){
        DatabaseReference target = root.child("announcements");

        ValueEventListener listener = new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<Announcement> announcements = new ArrayList<>();
                for (@NonNull DataSnapshot announcementsSnapshot : snapshot.getChildren()){
                    announcements.add(announcementsSnapshot.getValue(Announcements.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){
                handleDatabaseError(error);
            }
        };

        /**
         * Handles a database error and logs appropriate messages.
         *
         * @param error The DatabaseError instance.
         */
        /*
        private void handleDatabaseError(DatabaseError error) {
            if (error.getCode() == DatabaseError.PERMISSION_DENIED) {
                // Handle permission denied error
                // e.g., show a message to the user
                Log.e("DatabaseError", "Permission Denied");
            } else if (error.getCode() == DatabaseError.NETWORK_ERROR) {
                // Handle network error
                // e.g., show a message to the user to check their internet connection
                Log.e("DatabaseError", "Network Error");
            } else {
                // Handle other errors
                // e.g., show a generic error message
                Log.e("DatabaseError", "An unexpected error occurred: " + error.getMessage());
            }
        }
    */
        this.listenerTracker.addListener(target, listener);
    }

}
