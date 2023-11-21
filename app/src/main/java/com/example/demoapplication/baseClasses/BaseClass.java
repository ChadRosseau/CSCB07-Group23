package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public interface BaseClass {
    static DatabaseReference root = FirebaseDatabase.getInstance("https://cscb07-group23-default-rtdb.firebaseio.com").getReference();

    public static DatabaseReference getParentRef() {return root;};
}