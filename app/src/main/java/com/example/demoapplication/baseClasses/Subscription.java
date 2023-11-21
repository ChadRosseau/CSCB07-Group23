package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class Subscription implements BaseClass {
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

	public static DatabaseReference getParentRef() {
		return root.child("events").child("userSubscriptions");
	}
}
