package com.example.demoapplication.login;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.demoapplication.AuthModel;
import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.baseClasses.UserData;
import com.example.demoapplication.baseClasses.UserType;
import com.example.demoapplication.presenters.contracts.ListenerTracker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public interface LoginContract {
    interface LoginModel {
        void fetchCurrentUser();
        UserData getCurrentUserData();
        void logout();
        void createNewUser(String email, String password, OnCompleteListener<AuthResult> listener);
        void createNewUserData(FirebaseUser user, UserType userType);
        void signIn(String email, String password, OnCompleteListener<AuthResult> listener);
    }

    interface LoginView {
        void signUp();
        void signIn();
        void goToMain();
        void displayMessage(String text);
    }

    interface LoginPresenter {
        void signUp(String email, String password, boolean isAdmin);
        void signIn(String email, String password);
        void handleLogin(boolean success, LoginType type);
    }
}
