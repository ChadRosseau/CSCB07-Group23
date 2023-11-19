package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

public class User extends BaseClass {
	public static DatabaseReference parentRef = root.child("auth").child("users");
	private String uid;
	private String username;
	private UserType type;
	private String password;
	
	private User() {}
	
	public User(String uid, String username, UserType type, String password) {
		this.uid = uid;
		this.username = username;
		this.type = type;
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String uid) {
		this.username = username;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
