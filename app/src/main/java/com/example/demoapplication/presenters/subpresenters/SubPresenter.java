package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.AuthModel;
import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.listeners.ListenerTracker;

public abstract class SubPresenter {
    protected MainActivityView activity;
    protected MainActivityModel model;
    protected final ListenerTracker listenerTracker;
    protected AuthModel auth;

    public SubPresenter(MainActivityView activity) {
        this.model = MainActivityModel.getInstance();
        this.activity = activity;
        this.listenerTracker = new ListenerTracker();
        this.auth = AuthModel.getInstance();
    }

    public void endListeners() {
        this.listenerTracker.killListeners();
    }
}
