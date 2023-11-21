package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

public class Announcement extends Upload {
	private String announcementId;
	
	private Announcement() {}

	public Announcement(String announcementId, long timestamp, String title, String content, String author) {
		super(timestamp, title, content, author);
		this.announcementId = announcementId;
	}

	public String getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}

	public static DatabaseReference getParentRef() {
		return root.child("announcements");
	}
}
