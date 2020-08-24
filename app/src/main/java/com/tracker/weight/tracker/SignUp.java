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

public class SignUp extends AppCompatActivity {
    EditText username, password, height, weight, calories;
    Button submit;
    String u, p, w, c, h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //insert user to database at sign up

        DatabaseHandler db = new DatabaseHandler(this);

        //get the data from the sign up page
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        submit = (Button) findViewById(R.id.signupuser);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        calories = (EditText) findViewById(R.id.calories);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 u = username.getText().toString();
                 p = password.getText().toString();
                 w = weight.getText().toString();
                 c = calories.getText().toString();
                 h = height.getText().toString();
            }
        });

        db.addSQLContract(new sqlContract(u, p, w, c, h));
        openDashActivity();
    }

    public void openDashActivity() {
        Intent intent = new Intent(this, Dash.class);
        intent.putExtra("activity", "signup");
        startActivity(intent);
    }

}
