package com.example.demoapplication;

import androidx.annotation.NonNull;

import com.example.demoapplication.baseClasses.UserData;
import com.example.demoapplication.baseClasses.UserType;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

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

    public void signUp(String email, String password, boolean isAdmin) {
        if (email.isEmpty() || password.isEmpty()) view.displayInvalidInputMessage(InvalidInputType.Blank);
        else if (password.length() < 6) view.displayInvalidInputMessage(InvalidInputType.ShortPassword);
        else {
            OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    FirebaseUser user = task.getResult().getUser();
                    if (!task.isSuccessful() || user == null) {
                        handleLogin(false, LoginType.SignUp);
                    } else {
                        String uid = user.getUid();
                        String displayName = user.getDisplayName();
                        UserData userData = new UserData(uid, displayName, isAdmin ? UserType.Admin : UserType.Student);
                        DatabaseReference target = UserData.parentRef.child(uid);
                        model.setRef(target, userData);
                        handleLogin(task.isSuccessful(), LoginType.SignUp);
                    }
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
