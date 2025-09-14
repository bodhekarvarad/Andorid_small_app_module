package com.example.databaseoperation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class MyDatabase extends SQLiteOpenHelper {

    private static final String dbname = "MYdb.db";

    public MyDatabase(@Nullable Context context) {
        super(context, dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = "create table Student(Roll varchar(255) primary key autoincrement,Name varchar(255))";
        db.execSQL(q);
        String r = "select * from Student";
        db.execSQL(r);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Student");
        onCreate(db);

    }

    public String insertData(String roll, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Roll", roll);
        cv.put("Name", name);
        long res = db.insert("Student", null, cv);
        if (res == -1) {
            return "Insertion failed";
        } else {
            return "Insertion Sucessfully";
        }
    }

    public String readData() {
        SQLiteDatabase db=this.getReadableDatabase();
        String columns[]={"Roll","Name"};
      Cursor cursor=db.query("Student",columns,null,null,null,null,null);//null has present a clauses
        StringBuffer str=new StringBuffer();
        while (cursor.moveToNext())
        {
          String roll=cursor.getString( 0);//or get a columns name using accessing a value method is getColumnName(ColumnName);
            String name=cursor.getString(1);
            str.append(roll+" "+name+"\n");


        }
        return str.toString();


    }


    public String updateData(String roll, String name) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Name",name);
        String old_roll[]={roll};
        long res=db.update("Student",cv,"roll=?",old_roll);
        if(res==-1)
        {
            return "Update failed";
        }
        else
        {
            return "Successfully updated";
        }
    }

    public String deleteData(String roll) {
        SQLiteDatabase db=this.getWritableDatabase();
        String data[]={roll};
        long res=db.delete("Student","Roll?",data);
        if(res==0)
        {
            return "Delete failed";
        }
        else {
            return "Delete Successfully";
        }
    }
}


