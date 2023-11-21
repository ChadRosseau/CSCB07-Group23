package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

public class UserData implements BaseClass {
	public static DatabaseReference parentRef = root.child("auth").child("userData");
	private String uid;
	private String displayName;
	private UserType type;

	private UserData() {}

	public UserData(String uid, String displayName, UserType type) {
		this.uid = uid;
		this.displayName = displayName;
		this.type = type;
	}

	public String getUid() { return uid;}
	public String getDisplayName() { return displayName;}
	public UserType getUserType() { return type;}
}
