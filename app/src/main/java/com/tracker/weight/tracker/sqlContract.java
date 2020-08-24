package com.tracker.weight.tracker;

import android.provider.BaseColumns;

public class sqlContract {
    long id;
    String username;
    String password;
    String goal_wieght;
    String calorie;
    String height;

    private sqlContract(){}

    public sqlContract( String username, String password, String goal_weight, String calories, String height){
        this.username = username;
        this.password = password;
        this.goal_wieght = goal_weight;
        this.calorie = calories;
        this.height = height;
    }

    public String getUsername(){ return this.username;}
    public String getPassword(){ return this.password;}

    public void set_username(String u){ this.username = u;}
    public void set_password(String p){ this.password = p; }
    public void set_goal_wieght(String w){ this.goal_wieght = w; }
    public void set_calorie_target(String c) { this.calorie = c; }
    public void set_height(String h){ this.height = h; }
    public void set_ID(long id){ this.id = id;}

    public int getID(){ return this.getID(); }
    public String getGoal_wieght(){ return this.goal_wieght;}
    public String getCalorie_target(){ return  this.calorie; }
    public String getHeight(){ return this.height;}

    public sqlContract getCurrentUser(){ return this;}

}

