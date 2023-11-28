package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

import java.util.Objects;

public class UserData implements BaseClass {
	public static DatabaseReference parentRef = root.child("auth").child("userData");
	private String uid;
	private UserType type;

	private UserData() {}

	public UserData(String uid, int type) {
		this.uid = uid;
		if (type == 0) this.type = UserType.Admin;
		else this.type = UserType.Student;
	}

	public UserData(String uid, UserType type) {
		this.uid = uid;
		this.type = type;
	}

	public String getUid() { return uid;}
	public UserType getUserType() { return type;}

	public void setUserType(String type) {
		if (Objects.equals(type, UserType.Admin.toString())) this.type = UserType.Admin;
		else if (Objects.equals(type, UserType.Student.toString())) this.type = UserType.Student;
	}
}
