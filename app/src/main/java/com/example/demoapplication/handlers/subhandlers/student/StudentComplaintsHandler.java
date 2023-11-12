package com.example.demoapplication.handlers.subhandlers.student;

import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.handlers.subhandlers.ComplaintsHandler;
import com.example.demoapplication.handlers.subhandlers.SubHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Handles complaints for the student.
 * Extends the ComplaintsHandler class.
 */
public class StudentComplaintsHandler extends ComplaintsHandler {
    /**
     * Constructor for StudentComplaintsHandler.
     *
     * @param db  The Firebase database instance.
     * @param ref The database reference.
     */
    public StudentComplaintsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

    /**
     * Submits a complaint to the Firebase Realtime Database.
     *
     * @param title   The title of the complaint.
     * @param content The content of the complaint.
     * @param author  The author of the complaint.
     * @return The newly created Complaint object.
     */
    Complaint submitComplaint(String title, String content, String author) {
        // Generate a unique DB reference for the new complaint under "complaints" node.
        DatabaseReference target = root.child("complaints").push();
        // Retrieve key from the new reference.
        String complaintId = target.getKey();
        // Generate timestamp for the complaint.
        long unixTimestamp = System.currentTimeMillis() / 1000; // Current timestamp in seconds.
        // Create a new event object using the combination of parameters and generated data.
        Complaint newComplaint = new Complaint(complaintId, unixTimestamp, title, content, author);
        // Set the target DB ref to the new complaint object.
        target.setValue(newComplaint);
        return newComplaint;
    }

}
