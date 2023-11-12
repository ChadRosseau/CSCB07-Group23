package com.example.demoapplication.base_classes;

public class Metrics {
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

	public double getRating_sum() {
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
