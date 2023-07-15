package com.example.sportsquo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.sportsquo.Athlete;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AthleteManager";
    private static final String TABLE_ATHLETE = "Athletes";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_PLAYED = "played";
    private static final String KEY_WON = "won";
    private static final String KEY_BEST="best";
    private static final String KEY_TITLES = "titles";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE = "CREATE TABLE " + TABLE_ATHLETE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"+ KEY_AGE + " TEXT,"+ KEY_HEIGHT + " TEXT,"+ KEY_WEIGHT + " TEXT,"+ KEY_PLAYED + " TEXT,"
                + KEY_WON + " TEXT,"+ KEY_BEST + " TEXT,"+ KEY_TITLES+ " TEXT" + ")";
        db.execSQL(CREATE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATHLETE);
        onCreate(db);

    }
    void addAthlete(Athlete athlete) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, athlete.getName());
        values.put(KEY_AGE, athlete.getAge());
        values.put(KEY_HEIGHT, athlete.getHeight());
        values.put(KEY_WEIGHT, athlete.getWeight());
        values.put(KEY_PLAYED, athlete.getMatches_played());
        values.put(KEY_WON, athlete.getMatches_Won());
        values.put(KEY_BEST,athlete.getBest_Rating());
        values.put(KEY_TITLES,athlete.getTitles());

        // Inserting Row
        db.insert(TABLE_ATHLETE, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    Athlete getAthlete(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ATHLETE, new String[] { KEY_ID,
                        KEY_NAME, KEY_AGE,KEY_HEIGHT,KEY_WEIGHT,KEY_PLAYED,KEY_WON,KEY_BEST,KEY_TITLES }, KEY_NAME + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
         if(cursor.getCount()>0)
         {
            Athlete a = new Athlete(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)),
                    cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
            return a;
        }
        else
        {
            return null;
        }
    }

    public int updateAthlete(Athlete contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_AGE, contact.getAge());
        values.put(KEY_HEIGHT, contact.getHeight());
        values.put(KEY_WEIGHT, contact.getWeight());
        values.put(KEY_PLAYED, contact.getMatches_played());
        values.put(KEY_WON, contact.getMatches_Won());
        values.put(KEY_BEST, contact.getBest_Rating());
        values.put(KEY_TITLES, contact.getTitles());

        // updating row
        return db.update(TABLE_ATHLETE, values, KEY_NAME + " = ?",
                new String[] { String.valueOf(contact.getName()) });
    }

    public void deleteAthlete(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ATHLETE, KEY_NAME + " = ?",
                new String[] { String.valueOf(name) });
        db.close();
    }

}
