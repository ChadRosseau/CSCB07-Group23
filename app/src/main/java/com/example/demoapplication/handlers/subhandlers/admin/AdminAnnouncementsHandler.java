package com.example.demoapplication.handlers.subhandlers.admin;

import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.handlers.subhandlers.AnnouncementsHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class AdminAnnouncementsHandler extends AnnouncementsHandler {

    public AdminAnnouncementsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }

    Announcement createAnnouncement(String title, String content, String author) {
        DatabaseReference target = root.child("annoucements").push();
        String announcementId = target.getKey();
        long unixTimestamp = date.getTime() / 1000;
        Announcement newAnnouncement = new Announcement(announcementId, unixTimestamp, title, content, author);
        target.setValue(newAnnouncement);
        return newAnnouncement;
    }
}
