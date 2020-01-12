package com.example.uhsproject;

import android.database.Cursor;

import java.util.ArrayList;

public class ListData {

    DatabaseHelper mDatabaseHelper;
    ListData listData = new ListData();

    public ArrayList<String> pullNames() {
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> AccountName = new ArrayList<>();
        while (data.moveToNext()) {
            AccountName.add(data.getString(1));
        }
        return AccountName;
    }

    public ArrayList<String> pullDesc() {
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> AccountDesc = new ArrayList<>();
        while (data.moveToNext()) {
            AccountDesc.add(data.getString(2));

        }
        return AccountDesc;
    }

    public static String[] tutors = new String[]{
            "Tutor", "Tutor", "Tutor",
    };

    public static String[] tutorsdescription = new String[]{
        "Tutor", "Tutor", "Tutor", };

    public static int[] profilePicture = new int[]{
        R.drawable.profilepic, R.drawable.profilepic, R.drawable.profilepic,
        };
}