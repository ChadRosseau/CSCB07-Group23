package com.example.demoapplication;

import android.util.Log;

import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.baseClasses.UserData;
import com.example.demoapplication.baseClasses.UserType;
import com.example.demoapplication.presenters.contracts.ListenerTracker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class AuthModel {
    private static AuthModel authInstance = null;
    protected MainActivityModel model;
    protected FirebaseAuth mAuth;

    private FirebaseUser currentUser;
    private UserData currentUserData;
    private final ListenerTracker listenerTracker;

    protected AuthModel() {
        model = MainActivityModel.getInstance();
        mAuth = FirebaseAuth.getInstance();
        listenerTracker = new ListenerTracker();
        fetchCurrentUser();
    }

    public static AuthModel getInstance() {
        if (authInstance == null) authInstance = new AuthModel();
        return authInstance;
    }

    // Used when user may have changed.
    public void fetchCurrentUser() {
        this.listenerTracker.killListeners();
        this.currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            return;
        }
        ItemListenerCallback<UserData> callback = new ItemListenerCallback<UserData>() {
            public void execute(UserData data) {

                currentUserData = data;
            }
        };
        this.model.createSubscription(UserData.parentRef.child(currentUser.getUid()), this.listenerTracker, UserData.class, callback);
    }

    // Used when sure user hasn't changed.
    public UserData getCurrentUserData() {
        return this.currentUserData;
    }

    public void logout() {
        this.listenerTracker.killListeners();
        this.mAuth.signOut();
        this.currentUser = null;
        this.currentUserData = null;
    }
}
