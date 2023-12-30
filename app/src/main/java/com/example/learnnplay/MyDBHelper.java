package com.example.learnnplay;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="LearnNPlayDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_PARENT ="parent_user";
    public static final String KEY_PARENT_ID ="id";
    public static final String KEY_EMAIL ="email";
    public static final String KEY_PASSWORD ="password";
    public static final String TABLE_CHILD ="child_user";
    public static final String KEY_CHILD_NAME ="name";
    public static final String KEY_CHILD_ID ="id";
    public static final String KEY_CHILD_AGE ="age";
    public static final String KEY_SCORE ="score";





    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PARENT +"("+ KEY_PARENT_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_EMAIL + " TEXT,"+ KEY_PASSWORD + " TEXT" +")");

        db.execSQL("CREATE TABLE " + TABLE_CHILD +"("+ KEY_CHILD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_CHILD_NAME + " TEXT,"+ KEY_CHILD_AGE + " INTEGER," + KEY_SCORE + " INTEGER  NOT NULL DEFAULT 0" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHILD);
    }

    public void addParent(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        db.insert(TABLE_PARENT, null, values);
    }

    public void addChild(String name, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CHILD_NAME, name);
        values.put(KEY_CHILD_AGE, age);
        db.insert(TABLE_CHILD, null, values);
    }
}
