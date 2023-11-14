package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class Attendees extends BaseClass {
	public static DatabaseReference parentRef = root.child("events").child("eventAttendees");
	private String eventId;
	private List<String> attendees;
	
	private Attendees() {}

	public Attendees(String eventId, List<String> attendees) {
		this.eventId = eventId;
		this.attendees = attendees;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public List<String> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<String> attendees) {
		this.attendees = attendees;
	}
}
