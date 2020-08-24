package com.tracker.weight.tracker;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import android.os.Environment;
import java.util.*;
import android.database.sqlite.*;
import android.widget.EditText;
import android.content.Context;
import android.content.SharedPreferences;



public class Dash extends AppCompatActivity {
    Button log, editProfile;
    ImageView imageView;
    EditText weight, calories;
    ImageButton photo;
    boolean logdata = false;
    int current_user;
    SharedPreferences sp;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    String currentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        DatabaseHandler db = new DatabaseHandler(this);

        log = (Button) findViewById(R.id.uploaddaily);
        photo = (ImageButton) findViewById(R.id.camera);
        weight = (EditText)findViewById(R.id.weight);
        calories = (EditText)findViewById(R.id.calorie);
        editProfile = (Button) findViewById(R.id.viewprofile);

        photo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //function to call
                takePhoto();
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert data into Database
                log();
            }
        });


        if(logdata){
            //db.addLog(sp.getLong(), weight.getText().toString(), calories.getText().toString());
            logdata = false;
        }
    }

    public void log(){
        logdata = true;
    }

    public void takePhoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 7);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public void getCurrentUser(long id){

    }


}


