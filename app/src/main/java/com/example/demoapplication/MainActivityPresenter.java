package com.example.demoapplication;

import android.util.Log;

import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.baseClasses.UserData;
import com.example.demoapplication.presenters.AdminPresenter;
import com.example.demoapplication.presenters.StudentPresenter;

public class MainActivityPresenter {

    MainActivityModel model;
    MainActivityView view;
    public AdminPresenter admin;
    public StudentPresenter student;
    public AuthModel auth;

    public MainActivityPresenter(MainActivityView view, MainActivityModel model) {
        this.model = model;
        this.view = view;
        this.student = new StudentPresenter(view, model);
        this.admin = new AdminPresenter(view, model);
        this.auth = AuthModel.getInstance();
        auth.fetchCurrentUser();
    }
}
