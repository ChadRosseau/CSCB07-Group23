package com.example.demoapplication.handlers.subhandlers.student;

import com.example.demoapplication.handlers.subhandlers.ComplaintsHandler;
import com.example.demoapplication.handlers.subhandlers.SubHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentComplaintsHandler extends ComplaintsHandler {
    public StudentComplaintsHandler(FirebaseDatabase db, DatabaseReference ref) {
        super(db, ref);
    }
}
