package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.fragments.notifications.NotificationItem;
import com.example.demoapplication.fragments.notifications.NotificationsFragmentView;
import com.example.demoapplication.helpers.Helper;

import java.util.ArrayList;
import java.util.List;

public abstract class AnnouncementsPresenter extends SubPresenter {
    protected List<Announcement> announcements = new ArrayList<>();

    public AnnouncementsPresenter(MainActivityView view) {
        super(view);
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
            String timeStamp = Helper.formatTimestamp(announcement.getTimestamp());
            notificationList.add(0, new NotificationItem(announcement.getTitle(),
                    announcement.getType(), timeStamp, announcement.getContent()));
        }
        // Dummy data
        notificationList.add(new NotificationItem("Notification 1", "Announcement", "Nov 19, 2023", "You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. You are beautiful. "));
        view.setNotificationList(notificationList);
    }
}
