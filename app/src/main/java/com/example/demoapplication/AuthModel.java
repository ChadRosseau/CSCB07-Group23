package com.example.demoapplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthModel {
    protected FirebaseAuth mAuth;

    protected FirebaseUser currentUser;

    public AuthModel() {
        mAuth = FirebaseAuth.getInstance();
        fetchCurrentUser();
    }

    // Used when user may have changed.
    public FirebaseUser fetchCurrentUser() {
        this.currentUser = mAuth.getCurrentUser();
        return this.currentUser;
    }

    // Used when sure user hasn't changed.
    public FirebaseUser getCurrentUser() {
        return this.currentUser;
    }

    public void logout() {
        this.mAuth.signOut();
    }
}
