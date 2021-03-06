package com.example.uhsproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Accounts";
    private static final String COL0 = "ID";
    private static final String COL1 = "AccountName";
    private static final String COL2 = "AccountDesc";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL0 + "INTEGER PRIMARY KEY AUTOINCREMENT," +  COL1 + "TEXT," + COL2 + "TEXT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
    }

    public boolean addData (String item1, String item2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, item1);
        contentValues.put(COL2, item2);
        Long result = db.insertOrThrow(TABLE_NAME, null, contentValues);
        // if data is inserted incorrectly will return -1
        //Toast.makeText(DatabaseHelper.this,result.toString(),Toast.LENGTH_SHORT).show();
        db.close();
        if (result == -1){
            return false;
        }else {
            return true;
        }

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;
    }

}
