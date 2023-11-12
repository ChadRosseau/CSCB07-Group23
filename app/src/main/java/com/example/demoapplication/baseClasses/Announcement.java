package com.example.demoapplication.baseClasses;

public class Announcement extends Upload {
	private String announcementId;
	
	private Announcement() {}

	public Announcement(String announcementId, int timestamp, String title, String content, String author) {
		super(timestamp, title, content, author);
		this.announcementId = announcementId;
	}

	public String getAnnouncement_id() {
		return announcementId;
	}

	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}
	
}
