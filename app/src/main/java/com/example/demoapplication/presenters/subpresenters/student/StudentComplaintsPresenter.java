package com.example.demoapplication.presenters.subpresenters.student;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.fragments.complaints.StudentComplaintsFragmentView;
import com.example.demoapplication.helpers.Helper;
import com.example.demoapplication.presenters.subpresenters.ComplaintsPresenter;
import com.google.firebase.database.DatabaseReference;

/**
 * Presenter class for managing complaints from a student's perspective.
 */
public class StudentComplaintsPresenter extends ComplaintsPresenter {
    /**
     * Constructor for StudentComplaintsPresenter.
     *
     * @param activity  The associated MainActivityView.
     */
    public StudentComplaintsPresenter(MainActivityView activity) {
        super(activity);
    }

    /**
     * Creates a new complaint and adds it to the database.
     *
     * @param view The StudentComplaintsFragmentView currently initialised by activity.
     * @param title The title of the complaint.
     * @param content The content of the complaint.
     */
    public void createComplaint(StudentComplaintsFragmentView view, String title, String content) {
        if (title.isEmpty()) {
            view.handleCreateComplaintFailure("Subject cannot be empty!");
            return;
        } else if (content.isEmpty()) {
            view.handleCreateComplaintFailure("Description cannot be empty!");
            return;
        }
        // Get reference to push target
        DatabaseReference target = model.createChildRef(Complaint.parentRef);
        // Create additional necessary information
        String authorId = auth.getCurrentUserData().getUid();
        String complaintId = target.getKey();
        long timestamp = Helper.createTimestamp();
        // Create class instance
        Complaint newComplaint = new Complaint(complaintId, timestamp, title, content, authorId);
        // Instruct model to update database with instance
        model.setRef(target, newComplaint);
        // Alert user
        activity.toast("Announcement created!");
        view.handleCreateComplaintSuccess();
    }
}

