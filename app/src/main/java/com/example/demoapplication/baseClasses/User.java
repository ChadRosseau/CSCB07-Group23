package com.example.demoapplication.baseClasses;

public class User {
	private String uid;
	private String type;
	private String password;
	
	private User() {}
	
	public User(String uid, String type, String password) {
		this.uid = uid;
		this.type = type;
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
