package com.example.nangyalkhan.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Nangyal Khan on 4/10/2015.
 */
public class DataRet {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DataRet(Context ctx, String Name, Integer Rollno, String Desc)
    {
        dbHelper = new DBHelper(ctx);
        database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",Name);
        values.put("ROLLNO",Rollno);
        values.put("DESC",Desc);
        database.insert(dbHelper.TABLE,"",values);
        database.close();
    }
}
