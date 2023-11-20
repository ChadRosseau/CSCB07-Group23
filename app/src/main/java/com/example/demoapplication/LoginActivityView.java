package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivityView extends AppCompatActivity {

    private LoginActivityPresenter presenter;

    private EditText emailField;
    private EditText passwordField;
    public Button signUpButton;
    public Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create presenter
        this.presenter = new LoginActivityPresenter(this, new LoginActivityModel());

        setContentView(R.layout.login);

        emailField = (EditText)findViewById(R.id.emailField);
        passwordField = (EditText)findViewById(R.id.passwordField);

        signUpButton = (Button)findViewById(R.id.sign_up);
        signInButton = (Button)findViewById(R.id.sign_in);
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
        presenter.signUp(email, password);
    }

    public void signIn() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        presenter.signIn(email, password);
    }

    public void goToMain() {
        startActivity(new Intent(LoginActivityView.this, MainActivityView.class));
    }

    public void displayInvalidInputMessage(InvalidInputType type) {
        String text;
        switch (type) {
            case Blank:
                text = "Email and Password must be non-empty";
                break;
            case ShortPassword:
                text = "Password must be at least 6 characters long";
                break;
            default:
                text = "Invalid input";
                break;
        }
        Toast.makeText(LoginActivityView.this, text, Toast.LENGTH_LONG).show();
    }

    public void displayLoginFailed(LoginType type) {
        String text;
        switch (type) {
            case SignUp:
                text = "Failed to create account";
                break;
            case SignIn:
                text = "No matching email/password found";
                break;
            default:
                text = "Authentication failed";
                break;
        }
        Toast.makeText(LoginActivityView.this, text,
                Toast.LENGTH_SHORT).show();
    }
}