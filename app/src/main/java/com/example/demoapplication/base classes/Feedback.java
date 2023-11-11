package com.example.demoapplication;

import java.util.Map;

public class Feedback {
	private String event_id;
	private Map<String, String> comments;
	private Map<String, Integer> ratings;
	
	private Feedback() {}

	public Feedback(String event_id, Map<String, String> comments, Map<String, Integer> ratings) {
		this.event_id = event_id;
		this.comments = comments;
		this.ratings = ratings;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public Map<String, String> getComments() {
		return comments;
	}

	public void setComments(Map<String, String> comments) {
		this.comments = comments;
	}

	public Map<String, Integer> getRatings() {
		return ratings;
	}

	public void setRatings(Map<String, Integer> ratings) {
		this.ratings = ratings;
	}
}
