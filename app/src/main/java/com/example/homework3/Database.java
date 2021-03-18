package com.example.homework3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    String TABLE_NAME = "users";
    String COLUMN_NAME = "name";
    String COLUMN_LOCATION = "location";
    String COLUMN_PASSWORD = "password";
    String COLUMN_PHONE = "phone";
    SQLiteDatabase sqLiteDatabase;


    public Database(Context context) {
        super(context, "records.db", null, 1);
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_NAME + " text,"
                + COLUMN_LOCATION + " text,"
                +COLUMN_PASSWORD + " text,"
                +COLUMN_PHONE + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveUser(String name,String location, String password, String phone){
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_LOCATION,location);
        contentValues.put(COLUMN_PASSWORD,password);
        contentValues.put(COLUMN_PHONE,phone);

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public String userAllInfo(String Name){
        Cursor cursor;
        cursor = sqLiteDatabase.query(TABLE_NAME,null,COLUMN_NAME + "=?" , new String[]{Name},null,null,null);
        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
        String location = cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION));
        String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
        String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));

        return name + " " + location + " "+ password + " "+ password + " " + phone;
    }

    public String getUserPhone(String phone){
        Cursor cursor;
        cursor = sqLiteDatabase.query(TABLE_NAME,null,COLUMN_PHONE + "=?" , new String[]{phone},null,null,null);
        cursor.moveToFirst();
        if(cursor.getCount() < 1){
            return "-1";
        }

        String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));

        return password;

    }

    public String getUserName(String phone){
        Cursor cursor;
        cursor = sqLiteDatabase.query(TABLE_NAME,null,COLUMN_PHONE + "=?" , new String[]{phone},null,null,null);
        cursor.moveToFirst();

        return cursor.getString(cursor.getColumnIndex(COLUMN_NAME));

    }
}