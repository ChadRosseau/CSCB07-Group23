package com.example.demoapplication.base_classes;

import java.util.List;

public class Subscription {
	private String uid;
	private List<String> events;
	
	private Subscription() {}
	
	public Subscription(String uid, List<String> events) {
		this.uid = uid;
		this.events = events;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public List<String> getEvents() {
		return events;
	}
	public void setEvent_id(List<String> events) {
		this.events = events;
	}
}
