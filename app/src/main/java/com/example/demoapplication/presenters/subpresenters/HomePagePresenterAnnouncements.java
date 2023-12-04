package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.fragments.HomeFragmentView;
import com.example.demoapplication.presenters.listeners.ArrayListenerCallback;

import java.util.ArrayList;
import java.util.Collections;

public class HomePagePresenterAnnouncements extends SubPresenter {

    public HomePagePresenterAnnouncements(MainActivityView view) {
        super(view);
    }

    public void getAnnouncements(HomeFragmentView view){
        ArrayListenerCallback<Announcement> callback = new ArrayListenerCallback<Announcement>() {
            public void execute(ArrayList<Announcement> announcementList) {
                Collections.reverse(announcementList);
                view.setAnnouncementList(announcementList);
            }
        };
        model.createSubscription(Announcement.parentRef, this.listenerTracker, Announcement.class, callback);
    }
}
