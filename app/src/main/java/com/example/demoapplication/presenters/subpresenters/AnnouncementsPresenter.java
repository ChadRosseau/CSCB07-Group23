package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.presenters.listeners.ArrayListenerCallback;
import com.example.demoapplication.fragments.announcements.StudentAnnouncementsFragmentView;

import java.util.ArrayList;
import java.util.Collections;

public class AnnouncementsPresenter extends SubPresenter {

    public AnnouncementsPresenter(MainActivityView view) {
        super(view);
    }

    public void getAnnouncements(StudentAnnouncementsFragmentView view){
        ArrayListenerCallback<Announcement> callback = (announcementList) -> {
            Collections.reverse(announcementList);
            view.setAnnouncementList(announcementList);
        };
        model.createSubscriptionOnArray(Announcement.parentRef, this.listenerTracker, Announcement.class, callback);
    }
}
