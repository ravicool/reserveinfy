package com.example.teju.reserveinfy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class ReserveInfyDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "employee.db";
    public static final String TABLE_NAME = "employee_table";
    public static final String COL1 = "employee_Id";
    public static final String COL2 = "employee_Name";
    public static final String COL3 = "employee_Pass";
    public static final String COL4 = "employee_Email";
    public static final String COL5 = "employee_Mobile";
    public static final String COL6 = "employee_Transport";
    public static final String COL7 = "employee_TransportId";
    public static final String COL8 = "employee_Health";
    public static final String COL9 = "employee_HealthId";

    public ReserveInfyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + TABLE_NAME + " (employee_Id INTEGER PRIMARY KEY,employee_Name TEXT,employee_Pass TEXT,employee_Email TEXT,employee_Mobile INTEGER,employee_Transport TEXT,employee_TransportId INTEGER,employee_Health TEXT,employee_HealthId INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean InsertSignUp(String employee_Id,String employee_Name,String employee_Pass,String employee_Email,String employee_Mobile,String employee_Transport,String employee_TransportId,String employee_Health,String employee_HealthId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,employee_Id);
        contentValues.put(COL2,employee_Name);
        contentValues.put(COL3,employee_Pass);
        contentValues.put(COL4,employee_Email);
        contentValues.put(COL5,employee_Mobile);
        contentValues.put(COL6,employee_Transport);
        contentValues.put(COL7,employee_TransportId);
        contentValues.put(COL8,employee_Health);
        contentValues.put(COL9,employee_HealthId);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1)
            return false;
        else
            return true;

    }
}
