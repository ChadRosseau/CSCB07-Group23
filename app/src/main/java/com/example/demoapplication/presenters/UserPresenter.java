package com.example.demoapplication.presenters;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.subpresenters.AnnouncementsPresenter;
import com.example.demoapplication.presenters.subpresenters.ComplaintsPresenter;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;

public abstract class UserPresenter {
    protected MainActivityView view;
    protected MainActivityModel model;
    AnnouncementsPresenter announcements;
    ComplaintsPresenter complaints;
    EventsPresenter events;

    public UserPresenter(MainActivityView view, MainActivityModel model) {
        this.view = view;
        this.model = model;
    }
}
