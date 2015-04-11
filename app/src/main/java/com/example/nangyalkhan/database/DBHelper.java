package com.example.nangyalkhan.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Nangyal Khan on 4/8/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String TAG = "DBHelper";
    public static final String DB_NAME = "STUDENT";
    public static final String TABLE = "Class";
    public static final int DB_VAR = 1;
    public static final boolean DEBUG = false;
    public DBHelper(Context context) {
        super(context, DB_NAME, null,DB_VAR);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY = "Create Table " + TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ROLLNO TEXT, DESC TEXT)";
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor query(SQLiteDatabase db, String query) {
        Cursor cur = db.rawQuery(query,null);
        return cur;
    }
}
