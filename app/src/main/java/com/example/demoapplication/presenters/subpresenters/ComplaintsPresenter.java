package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;

public abstract class ComplaintsPresenter extends SubPresenter {
    public ComplaintsPresenter(MainActivityView view, MainActivityModel model) {
        super(view, model);
    }
}
