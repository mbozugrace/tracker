package com.tracker.weight.tracker;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.SharedPreferences;
import android.content.Context.*;
import android.content.Context;

import java.security.Key;
import java.util.*;
import java.lang.String;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private  static final String DATABASE_NAME = "weightGoals";
    private  static final String TABLE_CONTRACTS = "sqlContract";
    private static final String KEY_ID = "id";
    public static final String KEY_NAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_GOAL_WEIGHT = "goal_weight";
    public static final String KEY_CALORIES = "calorie_target";
    public static final String KEY_HEIGHT = "height";
    public static  final String LOG_TABLE = "progress";
    public  static  final String KEY_CURRENT_WEIGHT  = "weight";
    public static  final String KEY_USER = "user";
    public  static final String KEY_CURRENT_CALORIES = "calories";



    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_WEIGHT_GOALS_TABLE = "CREATE TABLE" + TABLE_CONTRACTS + "(" + KEY_ID + "INTEGER PRIMARY KEY" +
                KEY_NAME + "TEXT" + KEY_PASSWORD + "TEXT" + KEY_GOAL_WEIGHT + "TEXT" + KEY_CALORIES + "TEXT" +
                KEY_HEIGHT + "TEXT" + ")";

        String CREATE_LOG_TABLE = "CREATE TABLE" + LOG_TABLE + "(" + KEY_ID + "INTEGER PRIMARY KEY" +
                KEY_USER + "TEXT" + KEY_CURRENT_WEIGHT + "TEXT" + KEY_CURRENT_CALORIES + "KEY" + ")";

        db.execSQL(CREATE_WEIGHT_GOALS_TABLE);
        db.execSQL(CREATE_LOG_TABLE);
    }

    //upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTRACTS);
    }

    //code
    void addLog(long id, String w, String c){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(KEY_USER, id);
        v.put(KEY_CURRENT_WEIGHT, w);
        v.put(KEY_CURRENT_CALORIES, c);

        db.insert(LOG_TABLE, null, v);
        db.close();
    }


    //code to add the new contract
    void addSQLContract(sqlContract c){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //set this contracts key

        values.put(KEY_NAME, c.getUsername());
        values.put(KEY_PASSWORD, c.getPassword());
        values.put(KEY_GOAL_WEIGHT, c.getGoal_wieght());
        values.put(KEY_CALORIES, c.getCalorie_target());
        values.put(KEY_HEIGHT, c.getHeight());
        //insert this row
        db.insert(TABLE_CONTRACTS, null, values);
        //get thi slast rows primary it and set it as the objects id value
        long count = DatabaseUtils.queryNumEntries(db, TABLE_CONTRACTS);
        c.set_ID(count);

        db.close();
    }

    //code to get the contract
    sqlContract getContract(int d){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(TABLE_CONTRACTS, new String[]
                { KEY_ID, KEY_NAME}, KEY_ID + "=?",
                new String[] { String.valueOf(d)}, null, null,
                null, null);
        if(c != null)
            c.moveToFirst();

        sqlContract contract = new sqlContract(
        c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));

        return contract;
    }


    //update the user
    public int updateUser(sqlContract c){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, c.getUsername());
        values.put(KEY_PASSWORD, c.getPassword());
        values.put(KEY_HEIGHT, c.getHeight());
        values.put(KEY_GOAL_WEIGHT, c.getGoal_wieght());
        values.put(KEY_CALORIES, c.getCalorie_target());

        return db.update(TABLE_CONTRACTS, values, KEY_ID + "=?",
                new String[] {String.valueOf(c.getID())});
    }

    //delete
    public void deleteUser(sqlContract c){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTRACTS, KEY_ID + "=?",
                new String[]{ String.valueOf(c.getID())});
        db.close();
    }

}
