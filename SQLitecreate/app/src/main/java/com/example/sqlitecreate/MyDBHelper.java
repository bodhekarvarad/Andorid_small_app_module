package com.example.sqlitecreate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
   private static final String DATABASE_NAME="ContactsDB";
   private static final int DATABASE_VERSION=1;
   private static final String TABLE_CONTACT="contacts";
   private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_PHONE_NO="phone_no";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE
        db.execSQL("CREATE TABLE "+TABLE_CONTACT+"(" +KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_NAME+"TEXT,"+KEY_PHONE_NO+"TEXT")");
        SQLiteDatabase datebase=this.get();
        datebase.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

         db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACT);
         onCreate(db);
    }
    public void addContact(String name,String phone_no)
    {

    }

}
