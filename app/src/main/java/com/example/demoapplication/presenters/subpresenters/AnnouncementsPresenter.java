package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.fragments.announcements.AnnouncementFragmentView;

import java.util.ArrayList;
import java.util.Collections;

public class AnnouncementsPresenter extends SubPresenter {

    public AnnouncementsPresenter(MainActivityView view) {
        super(view);
    }

    public void getAnnouncements(AnnouncementFragmentView view){
        ArrayListenerCallback<Announcement> callback = new ArrayListenerCallback<Announcement>() {
            public void execute(ArrayList<Announcement> announcementList) {
                Collections.reverse(announcementList);
                view.setAnnouncementList(announcementList);
            }
        };
        model.createSubscription(Announcement.parentRef, this.listenerTracker, Announcement.class, callback);
    }
}
