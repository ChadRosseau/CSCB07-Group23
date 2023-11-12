package com.example.demoapplication.baseClasses;

import java.util.List;

public class Attendees {
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
