package com.bol.cbdstatstracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.util.Log;

import java.util.Date;

import static android.support.constraint.Constraints.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "clientInfo";
    private static final String TABLE_BP = "bloodPressure";
    private static final String TABLE_MOOD = "moodInfo";
    private static final String TABLE_DOSAGE = "dosageInfo";
    private static final String TABLE_SYMPTOMS = "symptoms";
    private static final String TABLE_USAGE = "usage";
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";
    private static final String KEY_SYSTOLIC = "systolic";
    private static final String KEY_DIASTOLIC = "diastolic";
    private static final String KEY_SOLUTION = "tinctureOrSolution";
    private static final String KEY_TOD = "timeOfDay";
    private static final String KEY_NOTES = "notes";
    private static final String KEY_ELEVATED = "elevated";
    private static final String KEY_NORMAL = "normal";
    private static final String KEY_DEPRESSED = "depressed";
    private static final String KEY_ANXIETY = "anxiety";
    private static final String KEY_IRRITABLILITY = "irritablility";
    private static final String KEY_WEIGHT= "weight";
    private static final String KEY_SLEEP= "sleepDuration";
    private static final String KEY_WEEK= "weekNum";
    private static final String KEY_SYMPTOM= "symptom";
    private static final String KEY_SEVERITY = "severity";

    private static final String CREATE_BP_TABLE = "CREATE TABLE " + TABLE_BP + "(" + KEY_DATE + " TEXT, "
             + KEY_DIASTOLIC + " INTEGER, " + KEY_SYSTOLIC + " INTEGER )";
    private static final String CREATE_MOOD_TABLE = "CREATE TABLE " + TABLE_MOOD + "(" +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_DATE + " INTEGER, " + KEY_ELEVATED + "TEXT, " + KEY_NORMAL + "TEXT, " +
            KEY_DEPRESSED + "TEXT, " + KEY_ANXIETY + " INTEGER, " + KEY_IRRITABLILITY +" INTEGER, " + KEY_WEIGHT + " INTEGER, " + KEY_SLEEP + " INTEGER"+ ")";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BP_TABLE);
        db.execSQL(CREATE_MOOD_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BP);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MOOD);
        onCreate(db);

    }

    public boolean addBPData(int dia, int sys){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_DATE, new Date().getTime());
        contentValues.put(KEY_DIASTOLIC, dia);
        contentValues.put(KEY_SYSTOLIC, sys);

        Log.d(TAG, "addData: Adding " + dia + " " + sys +  " to " + TABLE_BP);

        long result = db.insert(TABLE_BP, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getBPData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_BP;
        Cursor data = db.rawQuery(query, null);
        return data;
    }




}




