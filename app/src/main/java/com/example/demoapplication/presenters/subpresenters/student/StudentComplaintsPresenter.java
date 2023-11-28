package com.example.demoapplication.presenters.subpresenters.student;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.helpers.Helper;
import com.example.demoapplication.presenters.subpresenters.ComplaintsPresenter;
import com.google.firebase.database.DatabaseReference;

/**
 * Presenter class for managing complaints from a student's perspective.
 */
public class StudentComplaintsPresenter extends ComplaintsPresenter {
    public StudentComplaintsPresenter(MainActivityView view) {
        super(view);
    }

    /**
     * Creates a new complaint and adds it to the database.
     *
     * @param title   The title of the complaint.
     * @param content The content of the complaint.
     * @param author  The author or creator of the complaint.
     * @return The newly created Complaint instance.
     */
    public Complaint createComplaint(String title, String content, String author) {
        // Get reference to push target
        DatabaseReference target = model.createChildRef(Complaint.parentRef);
        // Create additional necessary information
        String complaintId = target.getKey();
        long timestamp = Helper.createTimestamp();
        // Create class instance
        Complaint newComplaint = new Complaint(complaintId, timestamp, title, content, author);
        // Instruct model to update database with instance
        model.setRef(target, newComplaint);
        // Return instance
        return newComplaint;
    }
}

