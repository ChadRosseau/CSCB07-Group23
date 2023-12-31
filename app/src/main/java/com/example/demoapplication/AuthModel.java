package com.example.demoapplication;

import com.example.demoapplication.presenters.listeners.ItemListenerCallback;
import com.example.demoapplication.baseClasses.UserData;
import com.example.demoapplication.presenters.listeners.ListenerTracker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthModel {
    private static AuthModel authInstance = null;
    protected DatabaseModel model;
    protected FirebaseAuth mAuth;

    private FirebaseUser currentUser;
    private UserData currentUserData;
    private final ListenerTracker listenerTracker;

    protected AuthModel() {
        model = DatabaseModel.getInstance();
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
        ItemListenerCallback<UserData> callback = (data) -> currentUserData = data;
        this.model.createSubscription(UserData.parentRef.child(currentUser.getUid()), this.listenerTracker, UserData.class, callback);
    }

    // Used when sure user hasn't changed.
    public UserData getCurrentUserData() {
        return this.currentUserData;
    }

    // Perform necessary logout functions.
    public void logout() {
        this.listenerTracker.killListeners();
        this.mAuth.signOut();
        this.currentUser = null;
        this.currentUserData = null;
    }
}
