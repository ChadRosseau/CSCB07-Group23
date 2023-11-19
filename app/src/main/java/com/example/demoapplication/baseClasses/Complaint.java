package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

public class Complaint extends Upload {
	public static DatabaseReference parentRef = root.child("complaints");
	private String complaintId;
	
	private Complaint() {}

	public Complaint(String complaintId, long timestamp, String title, String content, String author) {
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
