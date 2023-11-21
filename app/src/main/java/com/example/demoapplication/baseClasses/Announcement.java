package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

public class Announcement extends Upload {
	public static DatabaseReference parentRef = root.child("announcements");
	private String announcementId;
	private String type;
	
	private Announcement() {}

	public Announcement(String announcementId, long timestamp, String title, String type, String content, String author) {
		super(timestamp, title, content, author);
		this.announcementId = announcementId;
		this.type = type;
	}

	public String getAnnouncementId() {
		return announcementId;
	}
	public String getType(){return type;}

	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}
	
}
