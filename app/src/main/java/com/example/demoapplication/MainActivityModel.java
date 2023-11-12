package com.example.demoapplication;

import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivityModel {
    DBHandler dbHandler;
    FirebaseDatabase db;

    public MainActivityModel(){
        db = FirebaseDatabase.getInstance("https://cscb07-group23-default-rtdb.firebaseio.com");
        dbHandler = new DBHandler(this.db);
    }

    public void queryDB(MainActivityPresenter presenter, String username){
        DatabaseReference ref = db.getReference();
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
