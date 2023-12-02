package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

public class Event implements BaseClass, Serializable {
	public static DatabaseReference parentRef = root.child("events").child("eventList");
	private String eventId;
	private String title;
	private String description;
	private int attendeeCount;
	private int maxAttendees;
	private long date;

	private String location;

	private Event() {}

	public Event(String eventId, String title, String description, int attendeeCount, int maxAttendees, long date, String location) {
		this.eventId = eventId;
		this.title = title;
		this.description = description;
		this.attendeeCount = attendeeCount;
		this.maxAttendees = maxAttendees;
		this.date = date;
		this.location = location;
	}

	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
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
	public int getAttendeeCount() {
		return attendeeCount;
	}
	public void setAttendeeCount(int attendeeCount) {
		this.attendeeCount = attendeeCount;
	}
	public int getMaxAttendees() {
		return maxAttendees;
	}
	public void setMaxAttendees(int maxAttendees) {
		this.maxAttendees = maxAttendees;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Event)){
			return false;
		}
		Event other = (Event)obj;
		return this.eventId.equals(other.getEventId());
	}
}
