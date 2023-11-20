package com.example.demoapplication;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

enum InvalidInputType {
    Blank,
    ShortPassword,
}

enum LoginType {
    SignUp,
    SignIn,
}

public class LoginActivityPresenter {
    LoginActivityView view;
    LoginActivityModel model;

    public LoginActivityPresenter(LoginActivityView view, LoginActivityModel model) {
        this.view = view;
        this.model = model;
    }

    public void signUp(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) view.displayInvalidInputMessage(InvalidInputType.Blank);
        else if (password.length() < 6) view.displayInvalidInputMessage(InvalidInputType.ShortPassword);
        else {
            OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    handleLogin(task.isSuccessful(), LoginType.SignUp);
                }
            };
            this.model.createNewUser(email, password, listener);
        }
    }

    public void signIn(String email, String password) {
        if (email.isEmpty() || password.isEmpty())
            view.displayInvalidInputMessage(InvalidInputType.Blank);
        else {
            OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    handleLogin(task.isSuccessful(), LoginType.SignIn);
                }
            };
            this.model.signIn(email, password, listener);
        }
    }

    public void handleLogin(boolean success, LoginType type) {
        if (!success) view.displayLoginFailed(type);
        else {
            model.fetchCurrentUser();
            view.goToMain();
        }
    }
}
