package com.example.demoapplication.base_classes;

public class Complaint extends Upload{
	private String complaint_id;
	
	private Complaint() {}

	public Complaint(String complaint_id, int timestamp, String title, String content, String author) {
		super(timestamp, title, content, author);
		this.complaint_id = complaint_id;
	}

	public String getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(String complaint_id) {
		this.complaint_id = complaint_id;
	}
}
