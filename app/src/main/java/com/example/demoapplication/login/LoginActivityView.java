package com.example.demoapplication.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;

public class LoginActivityView extends AppCompatActivity implements LoginContract.LoginView {

    private LoginActivityPresenter presenter;

    private EditText emailField;
    private EditText passwordField;
    private SwitchCompat adminSwitch;
    private Button signUpButton;
    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create presenter
        this.presenter = new LoginActivityPresenter(this, new LoginActivityModel());

        setContentView(R.layout.login);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        adminSwitch = findViewById(R.id.adminSwitch);

        signUpButton = findViewById(R.id.signUpButton);
        signInButton = findViewById(R.id.signInButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    public void signUp() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        boolean isAdmin = adminSwitch.isChecked();
        presenter.signUp(email, password, isAdmin);
    }

    public void signIn() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        presenter.signIn(email, password);
    }

    public void goToMain() {
        startActivity(new Intent(LoginActivityView.this, MainActivityView.class));
        finish();
    }

    public void displayMessage(String text) {
        Toast.makeText(LoginActivityView.this, text, Toast.LENGTH_SHORT).show();
    }
}