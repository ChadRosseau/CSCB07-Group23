package com.example.demoapplication;

public class Upload {
	private int timestamp;
	private String title;
	private String content;
	private String author;
	
	protected Upload() {}
	
	public Upload(int timestamp, String title, String content, String author) {
		this.timestamp = timestamp;
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
