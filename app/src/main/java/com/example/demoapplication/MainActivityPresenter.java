package com.example.demoapplication;

import com.example.demoapplication.presenters.AdminPresenter;
import com.example.demoapplication.presenters.StudentPresenter;
import com.example.demoapplication.presenters.subpresenters.AuthPresenter;

public class MainActivityPresenter {

    MainActivityModel model;
    MainActivityView view;
    AdminPresenter admin;
    StudentPresenter student;
    AuthPresenter auth;

    public MainActivityPresenter(MainActivityView view, MainActivityModel model) {
        this.model = model;
        this.view = view;
        this.auth = new AuthPresenter(view, model);
        this.student = new StudentPresenter(view, model);
        this.admin = new AdminPresenter(view, model);
    }


<<<<<<< HEAD
    public void checkDB(String username) {
        if (username.equals(""))
        {
            view.setOutputText("String cannot be empty!");
        }
//        else
        {
//            model.queryDB(this, username);
        }
    }
=======
//    public void checkDB(String username) {
//        if (username.equals(""))
//        {
////            view.setOutputText("String cannot be empty!");
//        }
//        else
//        {
//            model.queryDB(this, username);
//        }
//    }
>>>>>>> main

//    public void setViewText(boolean exists) {
//        if (exists)
//        {
//            view.setOutputText("Found it!");
//        }
//        else
//        {
//            view.setOutputText("Couldn't find it!");
//        }
//    }
}
