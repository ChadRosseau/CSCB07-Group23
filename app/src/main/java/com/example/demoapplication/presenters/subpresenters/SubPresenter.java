package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.AuthModel;
import com.example.demoapplication.DatabaseModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.listeners.ListenerTracker;

public abstract class SubPresenter {
    protected MainActivityView activity;
    protected DatabaseModel model;
    protected final ListenerTracker listenerTracker;
    protected AuthModel auth;

    /**
     * Constructor for SubPresenter.
     *
     * @param activity  The associated MainActivityView.
     */
    public SubPresenter(MainActivityView activity) {
        this.activity = activity;
        this.model = DatabaseModel.getInstance();
        this.auth = AuthModel.getInstance();
        this.listenerTracker = new ListenerTracker();
    }

    public void endListeners() {
        this.listenerTracker.killListeners();
    }
}
