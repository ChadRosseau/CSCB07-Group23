package com.example.demoapplication.baseClasses;

public class Complaint extends Upload{
	private String complaintId;
	
	private Complaint() {}

	public Complaint(String complaintId, int timestamp, String title, String content, String author) {
		super(timestamp, title, content, author);
		this.complaintId = complaintId;
	}

	public String getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}
}
