package com.example.demoapplication.presenters.subpresenters.admin;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.presenters.subpresenters.ComplaintsPresenter;

import java.util.List;

public class AdminComplaintsPresenter extends ComplaintsPresenter {
    public AdminComplaintsPresenter(MainActivityView view) {
        super(view);
    }

    public void getComplaints(){
        ArrayListenerCallback<Complaint> callback = new ArrayListenerCallback<Complaint>() {
            public void execute(List<Complaint> complaintList) {
                for (Complaint complaint : complaintList) {
                    System.out.println(complaint);
                }
            }
        };
        model.createSubscription(Complaint.parentRef, this.listenerTracker, Complaint.class, callback);
    }
}
