package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

public class UserData implements BaseClass {
	public static DatabaseReference parentRef = root.child("auth").child("userData");
	private String uid;
	private UserType type;

	private UserData() {}

	public UserData(String uid, UserType type) {
		this.uid = uid;
		this.type = type;
	}

	public String getUid() { return uid;}
	public UserType getUserType() { return type;}
}
