package com.example.demoapplication;

import com.example.demoapplication.presenters.AdminPresenter;
import com.example.demoapplication.presenters.StudentPresenter;

public class MainActivityPresenter {

    MainActivityModel model;
    MainActivityView view;
    AdminPresenter admin;
    StudentPresenter student;
    AuthModel auth;

    public MainActivityPresenter(MainActivityView view, MainActivityModel model) {
        this.model = model;
        this.view = view;
//        this.auth = new AuthPresenter(view, model);
        this.student = new StudentPresenter(view, model);
        this.admin = new AdminPresenter(view, model);
        this.auth = AuthModel.getInstance();
    }


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
