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

    public static String[] tutors = new String[] {"tutor", "tutor", "tutor"};
    public static String[] tutorsdescription = new String[] {"tutor", "tutor", "tutor"};
    public static int[] profilePicture = new int[]{R.drawable.profilepic,R.drawable.profilepic,R.drawable.profilepic};
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

}