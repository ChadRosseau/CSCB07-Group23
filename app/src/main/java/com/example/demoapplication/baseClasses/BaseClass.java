package com.example.demoapplication.baseClasses;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class BaseClass {
    static FirebaseDatabase db = FirebaseDatabase.getInstance("https://cscb07-group23-default-rtdb.firebaseio.com");
    static DatabaseReference root = db.getReference();
    protected DatabaseReference parentRef;

    public DatabaseReference getParentRef() {return this.parentRef;}
}