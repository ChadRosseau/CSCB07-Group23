package com.example.demoapplication.presenters.subpresenters.admin;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.presenters.subpresenters.AnnouncementsPresenter;
import com.example.demoapplication.helpers.Helper;
import com.google.firebase.database.DatabaseReference;

public class AdminAnnouncementsPresenter extends AnnouncementsPresenter {
    /**
     * Constructor for AdminAnnouncementsPresenter.
     *
     * @param activity  The associated MainActivityView.
     */
    public AdminAnnouncementsPresenter(MainActivityView activity) {
        super(activity);
    }

    /**
     * Creates a new event and adds it to the database.
     *
     * @param title The title of the announcement.
     * @param type The type of the announcement.
     * @param content The content of the announcement.
     */
    public void createAnnouncement(String title, String type, String content) {
        // Get reference to push target
        DatabaseReference target = model.createChildRef(Announcement.parentRef);
        // Create additional necessary information
        String authorId = auth.getCurrentUserData().getUid();
        String announcementId = target.getKey();
        long timestamp = Helper.createTimestamp();
        // Create class instance
        Announcement newAnnouncement = new Announcement(announcementId, timestamp, title, type, content, authorId);
        // Instruct model to update database with instance
        model.setRef(target, newAnnouncement);
        // Alert user
        activity.toast("Announcement created!");
    }
}
