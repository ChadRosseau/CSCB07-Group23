package com.example.demoapplication;

public class Event {
	private String event_id;
	private String title;
	private String description;
	private int attendee_count;
	private int date;
	
	private Event() {}
	
	public Event(String event_id, String title, String description, int attendee_count, int date) {
		this.event_id = event_id;
		this.title = title;
		this.description = description;
		this.attendee_count = attendee_count;
		this.date = date;
	}

	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAttendee_count() {
		return attendee_count;
	}
	public void setAttendee_count(int attendee_count) {
		this.attendee_count = attendee_count;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
}
