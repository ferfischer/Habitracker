package com.fernandofischer.habitracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fernandofischer.habitracker.data.HabitContract.HabitEntry;
import com.fernandofischer.habitracker.data.HabitDBHelper;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // INSERINDO:
        Date now = new Date();

        HabitDBHelper mDbHelper = new HabitDBHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues fields = new ContentValues();

        fields.put(HabitEntry.COLUMN_HABIT_NAME, "Andar de bicicleta");
        fields.put(HabitEntry.COLUMN_HABIT_TIME, now.getTime());

        db.insert(HabitEntry.TABLE_NAME, null, fields);

        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_TIME,
                HabitEntry.COLUMN_HABIT_NAME
        };

        // CONSULTANDO:
        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);

        int idxId = cursor.getColumnIndex(HabitEntry._ID);
        int idxName = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
        int idxTime = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_TIME);

        while (cursor.moveToNext()) {
            Log.v(LOG_TAG,"New habit inserted: "+cursor.getInt(idxId)+" - "+cursor.getString(idxName)+" - "+ cursor.getInt(idxTime));
        }

    }
}
