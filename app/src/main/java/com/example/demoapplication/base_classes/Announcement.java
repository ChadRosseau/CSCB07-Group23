package com.example.demoapplication.base_classes;

import com.example.demoapplication.Upload;

public class Announcement extends Upload {
	private String announcement_id;
	
	private Announcement() {}

	public Announcement(String announcement_id, int timestamp, String title, String content, String author) {
		super(timestamp, title, content, author);
		this.announcement_id = announcement_id;
	}

	public String getAnnouncement_id() {
		return announcement_id;
	}

	public void setAnnouncement_id(String announcement_id) {
		this.announcement_id = announcement_id;
	}
	
}
