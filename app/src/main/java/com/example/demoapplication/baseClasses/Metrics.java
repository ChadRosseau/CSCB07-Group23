package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

public class Metrics extends BaseClass {
	public static DatabaseReference parentRef = root.child("events").child("feedbackMetrics");
	private String eventId;
	private double ratingSum;
	private int ratingCount;
	
	private Metrics() {}

	public Metrics(String eventId, double ratingSum, int ratingCount) {
		this.eventId = eventId;
		this.ratingSum = ratingSum;
		this.ratingCount = ratingCount;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public double getRatingSum() {
		return ratingSum;
	}

	public void setRatingSum(double ratingSum) {
		this.ratingSum = ratingSum;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
}
