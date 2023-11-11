package com.example.demoapplication;

public class Metrics {
	private String event_id;
	private double rating_sum;
	private int rating_count;
	
	private Metrics() {}

	public Metrics(String event_id, double rating_sum, int rating_count) {
		this.event_id = event_id;
		this.rating_sum = rating_sum;
		this.rating_count = rating_count;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public double getRating_sum() {
		return rating_sum;
	}

	public void setRating_sum(double rating_sum) {
		this.rating_sum = rating_sum;
	}

	public int getRating_count() {
		return rating_count;
	}

	public void setRating_count(int rating_count) {
		this.rating_count = rating_count;
	}
}
