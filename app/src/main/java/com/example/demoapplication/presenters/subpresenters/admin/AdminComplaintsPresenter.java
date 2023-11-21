package com.example.demoapplication.presenters.subpresenters.admin;

import androidx.annotation.NonNull;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityPresenter;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.baseClasses.ListenerCallback;
import com.example.demoapplication.presenters.subpresenters.ComplaintsPresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminComplaintsPresenter extends ComplaintsPresenter {
    public AdminComplaintsPresenter(MainActivityView view, MainActivityModel model) {
        super(view, model);
    }

    public void getComplaints(){
        ArrayListenerCallback<Complaint> callback = new ArrayListenerCallback<Complaint>() {
            public void execute(List<Complaint> complaintList) {
                for (Complaint complaint : complaintList) {
                    System.out.println(complaint);
                }
            }
        };
        model.createSubscription(Complaint.getParentRef(), this.listenerTracker, Complaint.class, callback);
    }
}
