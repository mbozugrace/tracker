package com.tracker.weight.tracker;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.database.sqlite.*;
import java.util.*;
import android.widget.EditText;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button homelogin, homesubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homesubmit = (Button) findViewById(R.id.signup);
        homelogin = (Button) findViewById(R.id.login);

        homesubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpActivity();
            }
        });

        homelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogInActivity();
            }
        });
    }

    //this code opens the sign up and log in activities 

    public void openSignUpActivity() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void openLogInActivity() {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

}
