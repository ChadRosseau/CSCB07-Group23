package com.example.demoapplication.presenters.subpresenters.admin;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.presenters.subpresenters.AnnouncementsPresenter;
import com.example.demoapplication.helpers.Helper;
import com.google.firebase.database.DatabaseReference;

public class AdminAnnouncementsPresenter extends AnnouncementsPresenter {

    public AdminAnnouncementsPresenter(MainActivityView view) {
        super(view);
    }

    public Announcement createAnnouncement(String title, String type, String content) {
        // Get reference to push target
        DatabaseReference target = model.createChildRef(Announcement.parentRef);
        // Create additional necessary information
        String announcementId = target.getKey();
        long timestamp = Helper.createTimestamp();
        String authorId = auth.getCurrentUserData().getUid();
        // Create class instance
        Announcement newAnnouncement = new Announcement(announcementId, timestamp, title, type, content, authorId);
        // Instruct model to update database with instance
        model.setRef(target, newAnnouncement);
        // Return instance
        return newAnnouncement;
    }
}
