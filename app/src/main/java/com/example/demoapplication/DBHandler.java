package com.example.demoapplication;

import com.example.demoapplication.MainActivityPresenter;
import com.example.demoapplication.handlers.AdminHandler;
import com.example.demoapplication.handlers.StudentHandler;
import com.example.demoapplication.handlers.subhandlers.AuthHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class DBHandler {

    private final FirebaseDatabase db;
    AdminHandler admin;
    StudentHandler student;
    AuthHandler auth;
    

    public DBHandler(FirebaseDatabase db){
        this.db = db;
        DatabaseReference ref = db.getReference();
        this.auth = new AuthHandler(db, ref);
        this.student = new StudentHandler(db, ref);
        this.admin = new AdminHandler(db, ref);
    }

    public void queryDB(MainActivityPresenter presenter, String username){
        DatabaseReference ref= db.getReference();
        DatabaseReference query = ref.child("users").child(username);

        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                presenter.setViewText(snapshot.exists());
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

}
