package com.example.demoapplication.base_classes;

import java.util.Map;

public class Feedback {
	private String eventId;
	private Map<String, String> comments;
	private Map<String, Integer> ratings;
	
	private Feedback() {}

	public Feedback(String eventId, Map<String, String> comments, Map<String, Integer> ratings) {
		this.eventId = eventId;
		this.comments = comments;
		this.ratings = ratings;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
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
