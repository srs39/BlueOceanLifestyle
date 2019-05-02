package com.bol.blueoceanlifestyle;

/*import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "clientInfo";
    private static final String TABLE_BP = "bloodPressure";
    private static final String TABLE_MOOD = "moodInfo";
    private static final String TABLE_DOSAGE = "dosageInfo";
    private static final String TABLE_SYMPTOMS = "symptoms";
    private static final String TABLE_USAGE = "usage";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";
    private static final String KEY_SYSTOLIC = "systolic";
    private static final String KEY_DIASTOLIC = "diastolic";
    private static final String KEY_SOLUTION = "tinctureOrSolution";
    private static final String KEY_TOD = "timeOfDay";
    private static final String KEY_NOTES = "notes";
    private static final String KEY_ELEVATED = "elevated";
    private static final String KEY_NORMAL = "normal";
    private static final String KEY_DEPRESSED = "depressed";
    private static final String KEY_ANXIETY = "anxiety";
    private static final String KEY_WEIGHT= "weight";
    private static final String KEY_SLEEP= "sleepDuration";
    private static final String KEY_WEEK= "weekNum";
    private static final String KEY_SYMPTOM= "symptom";
    private static final String KEY_SEVERITY = "severity";

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BP_TABLE = "CREATE TABLE " + TABLE_BP + "(" + KEY_DATE + " INTEGER PRIMARY KEY, "
                + KEY_TIME + " INTEGER, " + KEY_DIASTOLIC + " INTEGER, " + KEY_SYSTOLIC + "INTEGER )";
        db.execSQL(CREATE_BP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BP);
        onCreate(db);

    }

    void addBP(){

    }
}*/
