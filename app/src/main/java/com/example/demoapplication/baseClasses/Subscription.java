package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class Subscription extends BaseClass {
	public static DatabaseReference parentRef = root.child("events").child("userSubscriptions");
	private List<String> events;
	
	private Subscription() {}
	
	public Subscription(List<String> events) {
		this.events = events;
	}
	public List<String> getEvents() {
		return events;
	}
	public void setEvents(List<String> events) {
		this.events = events;
	}
}
