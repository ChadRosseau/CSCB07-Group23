package com.example.demoapplication.presenters.subpresenters.admin;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.listeners.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.fragments.complaints.AdminComplaintsFragmentView;
import com.example.demoapplication.presenters.subpresenters.ComplaintsPresenter;

import java.util.ArrayList;
import java.util.Collections;

public class AdminComplaintsPresenter extends ComplaintsPresenter {
    public AdminComplaintsPresenter(MainActivityView view) {
        super(view);
    }

    public void getComplaints(AdminComplaintsFragmentView view){
        ArrayListenerCallback<Complaint> callback = new ArrayListenerCallback<Complaint>() {
            public void execute(ArrayList<Complaint> complaintList) {
                Collections.reverse(complaintList);
                view.setComplaintList(complaintList);
            }
        };
        model.createSubscription(Complaint.parentRef, this.listenerTracker, Complaint.class, callback);
    }
}
