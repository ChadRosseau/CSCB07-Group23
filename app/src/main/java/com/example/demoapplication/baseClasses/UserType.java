package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;

public enum UserType implements BaseClass {
    Admin,
    Student;

    public static DatabaseReference getParentRef() {
        return root.child("auth").child("userTypes");
    }
}
