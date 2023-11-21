package com.example.demoapplication;

import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.baseClasses.UserType;
import com.example.demoapplication.presenters.contracts.ListenerTracker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class AuthModel extends MainActivityModel {
    private static AuthModel authInstance = null;
    protected FirebaseAuth mAuth;

    private FirebaseUser currentUser;
    private UserType currentUserType;
    private ListenerTracker listenerTracker;

    private AuthModel() {
        mAuth = FirebaseAuth.getInstance();
        listenerTracker = new ListenerTracker();
        fetchCurrentUser();
    }

    public static AuthModel getInstance() {
        if (authInstance == null) authInstance = new AuthModel();
        return authInstance;
    }

    // Used when user may have changed.
    public FirebaseUser fetchCurrentUser() {
        this.listenerTracker.killListeners();
        this.currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
        ItemListenerCallback<UserType> callback = new ItemListenerCallback<UserType>() {
            public void execute(UserType type) {
                currentUserType = type;
            }
        };
        this.createSubscription(UserType.getParentRef().child(currentUser.getUid()), this.listenerTracker, UserType.class, callback);
        }
        return this.currentUser;
    }

    // Used when sure user hasn't changed.
    public FirebaseUser getCurrentUser() {
        return this.currentUser;
    }

    public UserType getCurrentUserType() {
        return this.currentUserType;
    }

    public void logout() {
        this.mAuth.signOut();
    }
}
