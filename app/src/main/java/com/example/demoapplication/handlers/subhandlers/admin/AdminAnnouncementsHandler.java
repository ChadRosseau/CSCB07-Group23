package com.example.demoapplication.handlers.subhandlers.admin;

import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.handlers.subhandlers.AnnouncementsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;


/**
 * Handles announcements for the admin.
 * Extends the AnnouncementsHandler class.
 */
public class AdminAnnouncementsHandler extends AnnouncementsHandler {

    /**
     * Constructor for AdminAnnouncementsHandler.
     *
     * @param db  The Firebase database instance.
     * @param ref The database reference.
     */
    public AdminAnnouncementsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

    /**
     * Creates a new announcement and adds it to the Firebase Realtime Database.
     *
     * @param title   The title of the announcement.
     * @param content The content of the announcement.
     * @param author  The author of the announcement.
     * @return The newly created Announcement object.
     */
    Announcement createAnnouncement(String title, String content, String author) {
        DatabaseReference target = root.child("annoucements").push();
        String announcementId = target.getKey();
        long unixTimestamp = date.getTime() / 1000;
        Announcement newAnnouncement = new Announcement(announcementId, unixTimestamp, title, content, author);
        target.setValue(newAnnouncement);
        return newAnnouncement;
    }
}
