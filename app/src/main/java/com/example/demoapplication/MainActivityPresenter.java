package com.example.demoapplication;

import android.util.Log;

import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.baseClasses.UserData;
import com.example.demoapplication.presenters.AdminPresenter;
import com.example.demoapplication.presenters.StudentPresenter;

public class MainActivityPresenter {

    MainActivityModel model;
    MainActivityView view;
<<<<<<< HEAD
    public AdminPresenter admin;
    public StudentPresenter student;
    AuthPresenter auth;
=======
    AdminPresenter admin;
    StudentPresenter student;
    public AuthModel auth;
>>>>>>> main

    public MainActivityPresenter(MainActivityView view, MainActivityModel model) {
        this.model = model;
        this.view = view;
        this.student = new StudentPresenter(view, model);
        this.admin = new AdminPresenter(view, model);
        this.auth = AuthModel.getInstance();
        auth.fetchCurrentUser();
    }
}
