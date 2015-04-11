package com.example.nangyalkhan.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.ref.SoftReference;

/**
 * Created by Nangyal Khan on 4/10/2015.
 */
public class DataRet {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DataRet(Context ctx, String Name, String Rollno, String Desc)
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

    public DataRet() {

    }

    public void GetInfo(Context ctx)
    {
        dbHelper = new DBHelper (ctx);
        database = dbHelper.getReadableDatabase();
        Cursor cur = dbHelper.query(database,"SELECT * FROM Class");
        cur.moveToFirst();
        String Name = "";
        String Rollno = "";
        String Desc = "";
        do {
            Name = cur.getString(cur.getColumnIndex("NAME"));
            Rollno = cur.getString(cur.getColumnIndex("ROLLNO"));
            Desc = cur.getString(cur.getColumnIndex("DESC"));
        } while (cur.moveToNext());
    }
    public String[] GetNames(Context ctx)
    {
        dbHelper = new DBHelper (ctx);
        database = dbHelper.getReadableDatabase();
        Cursor cur = dbHelper.query(database,"SELECT * FROM Class");
        cur.moveToFirst();
        String array[]=new String[cur.getCount()];
        int i=0;
        do {
            array[i] = cur.getString(cur.getColumnIndex("NAME"));
            i++;
        } while (cur.moveToNext());
       return array;
    }
    public  String[] GetRoll(Context ctx)
    {
        dbHelper = new DBHelper(ctx);
        database = dbHelper.getReadableDatabase();
        Cursor cur = dbHelper.query(database,"SELECT * FROM Class");
        cur.moveToFirst();
        String array[]=  new String[cur.getCount()];
        int o = 0;
        do {
            array[o] = cur.getString(cur.getColumnIndex("ROLLNO"));
            o++;
        }while (cur.moveToNext());
        return array;
    }
    public String[] GetDesc(Context ctx)
    {
        dbHelper = new DBHelper(ctx);
        database = dbHelper.getReadableDatabase();
        Cursor cur = dbHelper.query(database,"SELECT * FROM Class");
        cur.moveToFirst();
        String array[] = new String[cur.getCount()];
        int i = 0 ;
        do {
            array[i] = cur.getString(cur.getColumnIndex("DESC"));
            i++;
        }while (cur.moveToNext());
        return array;
    }
    public void UpdateInfo(Context ctx, String name, String Desc, String ID)
    {
        dbHelper = new DBHelper(ctx);
        database = dbHelper.getWritableDatabase();
        database.execSQL("UPDATE Class SET NAME = '"+ name +"' , DESC = '"+ Desc +"' WHERE ID = '" + ID + "'");
        Log.d("Updated", "Data Updated");
        database.close();
    }
    public void DeleteInfo(Context ctx, String ID)
    {
        dbHelper = new DBHelper(ctx);
        database = dbHelper.getWritableDatabase();
        database.execSQL("DELETE FROM Class WHERE ROLLNO = '" + ID + "'" );
        database.close();
    }
}
