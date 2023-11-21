package com.example.demoapplication.presenters.subpresenters.student;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.presenters.subpresenters.AnnouncementsPresenter;

import java.util.ArrayList;
import java.util.List;

public class StudentAnnouncementsPresenter extends AnnouncementsPresenter {
    public List<Announcement> announcements = new ArrayList<>();

    public StudentAnnouncementsPresenter(MainActivityView view, MainActivityModel model) {
        super(view, model);
    }

    public void getAnnouncements(){
        ArrayListenerCallback<Announcement> callback = new ArrayListenerCallback<Announcement>() {
            public void execute(List<Announcement> announcementList) {
                for (Announcement announcement : announcementList) {
                    System.out.println(announcement);
                    announcements.add(announcement);
                }
            }
        };
        model.createSubscription(Announcement.parentRef, this.listenerTracker, Announcement.class, callback);
    }
}
