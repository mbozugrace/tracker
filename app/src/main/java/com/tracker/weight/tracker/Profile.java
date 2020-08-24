package com.tracker.weight.tracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends AppCompatActivity {
    EditText weight_goal, calorie_goal, height;
    Button set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get the data from the sign up page
        weight_goal = (EditText)findViewById(R.id.weight);
        calorie_goal = (EditText)findViewById(R.id.calories);
        height = (EditText) findViewById(R.id.height);
        set = (Button) findViewById(R.id.setprofile);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String w = weight_goal.getText().toString();
                String c = calorie_goal.getText().toString();
                String h = height.getText().toString();
            }
        });

    }

}
