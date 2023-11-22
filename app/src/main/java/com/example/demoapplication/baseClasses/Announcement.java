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

	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Announcement)){
			return false;
		}
		Announcement other = (Announcement)obj;
		return this.announcementId.equals(other.getAnnouncementId());
	}
	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}
}
