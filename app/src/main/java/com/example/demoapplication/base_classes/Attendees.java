package com.example.demoapplication.base_classes;

import java.util.List;

public class Attendees {
	private String event_id;
	private List<String> attendees;
	
	private Attendees() {}

	public Attendees(String event_id, List<String> attendees) {
		this.event_id = event_id;
		this.attendees = attendees;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public List<String> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<String> attendees) {
		this.attendees = attendees;
	}
}
