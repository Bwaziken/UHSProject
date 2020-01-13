package com.example.uhsproject;

import android.database.Cursor;

import java.util.ArrayList;

public class ListData {


    static DatabaseHelper mDatabaseHelper;
    ListData listData = new ListData();
    static ArrayList<String> AccountName = new ArrayList<>();
    static ArrayList<String> AccountDesc = new ArrayList<>();
    public static ArrayList<String> pullNames() {
        Cursor data = mDatabaseHelper.getData();

        while (data.moveToNext()) {
            AccountName.add(data.getString(1));
        }
        return AccountName;
    }

    public static ArrayList<String> pullDesc() {
        Cursor data = mDatabaseHelper.getData();

        while (data.moveToNext()) {
            AccountDesc.add(data.getString(2));

        }
        return AccountDesc;
    }
// public static String[] tutors = new String[AccountName.size()];

    //public static String[] tutorsdescription = new String[AccountName.size()];

    // public static int[] profilePicture = new int[AccountName.size()];

    //public static void passes(){

    //for (int i=0;i<AccountName.size();i++){
    //tutors[i]=AccountName.get(i);
    //tutorsdescription[i]=AccountDesc.get(i);
    //profilePicture[i]=R.drawable.profilepic;

    // }

    //}
    public static String[] tutors = new String[] {"Jason Chen",
            "Derrick Yang", "Alexander Woo", "Michael Qian", "Sarah Smith", "Emily Cooke", "Tommy Hamilton", "Laura Ing", "Karen Cox", "Juan Lopez"};
    public static String[] tutorsdescription = new String[] {"Advanced Functions",
            "Chemistry", "Computer Science", "Physics", "English", "French", "Calculus", "Biology", "Accounting", "Data Management (Math)"};
    public static String[] tutorsdescription2 = new String[] {"Grade 12",
            "Grade 12", "Grade 12", "Grade 12", "Grade 11", "Grade 11", "Grade 11", "Grade 12", "Grade 11", "Grade 12"};
    public static String[] tutorsdescription3 = new String[] {"Available Mondays at 6:00-7:00PM",
            "Offering help in grade 12 chemistry anytime on weekends", "Available on Fridays after 4:00pm ", "Free for 1 hour on friday", "Available anytime on the weekends", "Can help for 1 hour any day", "Available Wednesdays at 4:00pm", "Offering help on Thursdays anytime", "Available mondays at 4:00PM", "Free to help every tuesday"};
    public static int[] profilePicture = new int[]{R.drawable.profilepic,R.drawable.profilepic,R.drawable.profilepic, R.drawable.profilepic,R.drawable.profilepic,
            R.drawable.profilepic,R.drawable.profilepic,R.drawable.profilepic,R.drawable.profilepic,R.drawable.profilepic};



}