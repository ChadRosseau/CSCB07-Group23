package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.fragments.NotificationItem;
import com.example.demoapplication.fragments.NotificationsFragmentView;

import java.util.ArrayList;
import java.util.List;

public abstract class AnnouncementsPresenter extends SubPresenter {
    protected List<Announcement> announcements = new ArrayList<>();

    public AnnouncementsPresenter(MainActivityView view, MainActivityModel model) {
        super(view, model);
    }

    public void getAnnouncements(NotificationsFragmentView view){
        ArrayListenerCallback<Announcement> callback = new ArrayListenerCallback<Announcement>() {
            public void execute(List<Announcement> announcementList) {
                for (Announcement announcement : announcementList) {
                    System.out.println(announcement);
                    if (!announcements.contains(announcement)){
                        announcements.add(announcement);
                    }
                }
                createNotificationList(view);
            }
        };
        model.createSubscription(Announcement.parentRef, this.listenerTracker, Announcement.class, callback);
    }

    public void createNotificationList(NotificationsFragmentView view){
        List<NotificationItem> notificationList = new ArrayList<>();
        for (Announcement announcement : announcements){
            notificationList.add(new NotificationItem(announcement.getTitle(),
                    announcement.getType(), "Nov 20, 2023", announcement.getContent()));
        }
        // Dummy data
        notificationList.add(new NotificationItem("Notification 1", "Announcement", "Nov 19, 2023", "You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. "));
        view.setNotificationList(notificationList);
    }
}
