package com.example.demoapplication;

public class MainActivityPresenter {

    MainActivityModel model;
    MainActivityView view;

    public MainActivityPresenter(MainActivityView view, MainActivityModel model) {
        this.model = model;
        this.view = view;
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
