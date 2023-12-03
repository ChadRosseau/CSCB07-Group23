package com.example.demoapplication.login;

import androidx.annotation.NonNull;

import com.example.demoapplication.baseClasses.UserType;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

enum InvalidInputType {
    Blank,
    ShortPassword,
}

public class LoginActivityPresenter implements LoginContract.LoginPresenter {
    LoginActivityView view;
    LoginActivityModel model;

    public LoginActivityPresenter(LoginActivityView view, LoginActivityModel model) {
        this.view = view;
        this.model = model;
        model.logout();
    }

    public void signUp(String email, String password, boolean isAdmin) {
        if (email.isEmpty() || password.isEmpty()) generateInvalidInputMessage(InvalidInputType.Blank);
        else if (password.length() < 6) generateInvalidInputMessage(InvalidInputType.ShortPassword);
        else {
            OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        handleLogin(false, LoginType.SignUp);
                        return;
                    }
                    FirebaseUser user = task.getResult().getUser();
                    if (user == null) {
                        handleLogin(false, LoginType.SignUp);
                        return;
                    }
                    model.createNewUserData(user, isAdmin ? UserType.Admin : UserType.Student);
                    handleLogin(task.isSuccessful(), LoginType.SignUp);
                }
            };
            this.model.createNewUser(email, password, listener);
        }
    }

    public void signIn(String email, String password) {
        if (email.isEmpty() || password.isEmpty())
            generateInvalidInputMessage(InvalidInputType.Blank);
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

    public void skipLogin(boolean isAdmin) {
        String email;
        String password;
        if (isAdmin) {
            email = "admin_test@gmail.com";
            password = "admin1234";
        } else {
            email = "student_test@gmail.com";
            password = "student1234";
        }
        this.signIn(email, password);
    }

    public void handleLogin(boolean success, LoginType type) {
        if (!success) generateLoginFailedMessage(type);
        else {
            view.goToMain();
        }
    }

    private void generateInvalidInputMessage(InvalidInputType type) {
        String text;
        switch (type) {
            case Blank:
                text = "Email and Password must be non-empty";
                break;
            case ShortPassword:
                text = "Password must be at least 6 characters long";
                break;
            default:
                text = "Invalid input";
                break;
        }
        view.displayMessage(text);
    }

    private void generateLoginFailedMessage(LoginType type) {
        String text;
        switch (type) {
            case SignUp:
                text = "Failed to create account";
                break;
            case SignIn:
                text = "No matching email/password found";
                break;
            default:
                text = "Authentication failed";
                break;
        }
        view.displayMessage(text);
    }
}
