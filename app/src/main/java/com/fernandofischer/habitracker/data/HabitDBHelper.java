package com.fernandofischer.habitracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.fernandofischer.habitracker.data.HabitContract.HabitEntry;

/**
 * Created by fernandofischer on 17/08/17.
 */

public class HabitDBHelper extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "habitracker.db";
    final static int DATABASE_VERSION = 1;

    public static final String LOG_TAG = HabitDBHelper.class.getSimpleName();

    public HabitDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE =  "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_TIME + " LONG NOT NULL ); ";

        Log.v(LOG_TAG,SQL_CREATE_HABITS_TABLE);

        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
