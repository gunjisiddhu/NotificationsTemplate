package com.example.notificationtemplate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table TimeTable(day TEXT primary key, per1 TEXT,per2 TEXT,per3 TEXT,per4 TEXT,per5 TEXT,per6 TEXT,per7 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists TimeTable");
    }

    public Boolean insertData(String day, String per1,String per2,String per3,String per4,String per5,String per6,String per7)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("day", day);
        contentValues.put("per1", per1);
        contentValues.put("per2", per2);
        contentValues.put("per3", per3);
        contentValues.put("per4", per4);
        contentValues.put("per5", per5);
        contentValues.put("per6", per6);
        contentValues.put("per7", per7);

        long result=DB.insert("TimeTable", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updateuserdata(String day, String per1,String per2,String per3,String per4,String per5,String per6,String per7)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("day", day);
        contentValues.put("per1", per1);
        contentValues.put("per2", per2);
        contentValues.put("per3", per3);
        contentValues.put("per4", per4);
        contentValues.put("per6", per5);
        contentValues.put("per6", per6);
        contentValues.put("per7", per7);
        Cursor cursor = DB.rawQuery("Select * from TimeTable where day = ?", new String[]{day});
        if (cursor.getCount() > 0) {
            long result = DB.update("TimeTable", contentValues, "day=?", new String[]{day});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Boolean deletedata (String day)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from TimeTable where day = ?", new String[]{day});
        if (cursor.getCount() > 0) {
            long result = DB.delete("TimeTable", "day=?", new String[]{day});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from TimeTable", null);
        return cursor;
    }

    public Cursor getDayData(String day){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from TimeTable where day = ?",new String[]{day});
        return cursor;
    }






}
