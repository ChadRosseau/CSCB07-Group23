package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivityView extends AppCompatActivity {

    boolean isFound = false;

    EditText editText;

    TextView textView;

    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        textView = (TextView) findViewById(R.id.output);
        presenter = new MainActivityPresenter(this, new MainActivityModel());
    }

    public void onClickCheck(View view){
        presenter.checkDB(editText.getText().toString());
    }

    public void setOutputText(String resultText)
    {
        textView.setText(resultText);
    }

}