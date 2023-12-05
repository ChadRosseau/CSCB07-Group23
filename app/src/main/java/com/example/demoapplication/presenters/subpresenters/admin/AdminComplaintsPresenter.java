package com.example.demoapplication.presenters.subpresenters.admin;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.listeners.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.fragments.complaints.AdminComplaintsFragmentView;
import com.example.demoapplication.presenters.subpresenters.ComplaintsPresenter;

import java.util.ArrayList;
import java.util.Collections;

public class AdminComplaintsPresenter extends ComplaintsPresenter {
    /**
     * Constructor for AdminComplaintsPresenter.
     *
     * @param activity  The associated MainActivityView.
     */
    public AdminComplaintsPresenter(MainActivityView activity) {
        super(activity);
    }

    /**
     * Retrieves current list of complaints and updates AdminComplaintsFragmentView.
     *
     * @param view The AdminComplaintsFragmentView currently initialised by activity.
     */
    public void getComplaints(AdminComplaintsFragmentView view){
        ArrayListenerCallback<Complaint> callback = (complaintList) -> {
            Collections.reverse(complaintList);
            view.setComplaintList(complaintList);
        };
        model.createSubscriptionOnArray(Complaint.parentRef, this.listenerTracker, Complaint.class, callback);
    }
}
