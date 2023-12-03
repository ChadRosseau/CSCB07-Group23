package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

import java.util.List;
import java.util.Map;

public class Subscription implements BaseClass {
	public static DatabaseReference parentRef = root.child("events").child("rsvps");
	private Map<String, Boolean> events;
	
	private Subscription() {}
	
	public Subscription(Map<String, Boolean> events) {
		this.events = events;
	}
	public Map<String, Boolean> getEvents() {
		return events;
	}
	public void setEvents(Map<String, Boolean> events) {
		this.events = events;
	}
}
