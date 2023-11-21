package com.example.demoapplication.presenters.subpresenters;

import androidx.annotation.NonNull;

import com.example.demoapplication.AuthModel;
import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.ListenerCallback;
import com.example.demoapplication.presenters.contracts.ListenerTracker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public abstract class SubPresenter {
    protected MainActivityView view;
    protected MainActivityModel model;
    protected ListenerTracker listenerTracker;
    protected AuthModel auth;

    public SubPresenter(MainActivityView view, MainActivityModel model) {
        this.view = view;
        this.model = model;
        this.listenerTracker = new ListenerTracker();
        this.auth = AuthModel.getInstance();
    }

    // Generates and manages a listener given a target and a callback function.
    // 2nd parameter is necessary to prevent type erasure issues.
}
