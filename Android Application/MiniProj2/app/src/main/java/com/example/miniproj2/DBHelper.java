package com.example.miniproj2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CourtManager";
    private static final String TABLE_LAWS = "Laws";
    private static final String KEY_CNR = "cnr";
    private static final String KEY_CASETYPE = "casetype";
    private static final String KEY_ADVOCATE = "advocate";
    private static final String KEY_DISTRICT = "district";
    private static final String KEY_TYPEOFCOURT = "typeofcourt";
    private static final String KEY_ACT = "act";
    private static final String KEY_PARTYNAME = "partyname";
    private static final String KEY_YEAR = "year";
    private static final String KEY_CASESTATUS = "status";
    private static final String KEY_DATE = "date";
    private static final String KEY_COURTNAME = "courtname";
    private static final String KEY_SECTION = "section";
    private static final String KEY_REGDATE="regdate";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE = "CREATE TABLE " + TABLE_LAWS + "("
                + KEY_CNR + " INTEGER PRIMARY KEY," + KEY_CASETYPE + " TEXT,"+ KEY_ADVOCATE + " TEXT,"+
                KEY_DISTRICT + " TEXT,"+ KEY_TYPEOFCOURT + " TEXT,"+ KEY_ACT + " TEXT,"
                + KEY_PARTYNAME + " TEXT," + KEY_CASESTATUS + " TEXT," + KEY_COURTNAME + " TEXT," + KEY_DATE + " TEXT," +
                KEY_YEAR +" TEXT," + KEY_SECTION + " TEXT," + KEY_REGDATE +" TEXT" + ")";
        db.execSQL(CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LAWS);
        onCreate(db);
    }

    void addDet(Laws laws) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CNR, laws.getCnr());
        values.put(KEY_ADVOCATE, laws.getAdvocate());
        values.put(KEY_ACT, laws.getAct());
        values.put(KEY_CASETYPE, laws.getCasetype());
        values.put(KEY_DISTRICT, laws.getDistrict());
        values.put(KEY_CASESTATUS, laws.getCaseStatus());
        values.put(KEY_DATE, laws.getDate());
        values.put(KEY_PARTYNAME, laws.getPartyname());
        values.put(KEY_TYPEOFCOURT, laws.getTypeofcourt());
        values.put(KEY_YEAR, laws.getYear());
        values.put(KEY_COURTNAME,laws.getCourtname());
        values.put(KEY_REGDATE,laws.getRegdate());
        values.put(KEY_SECTION,laws.getSection());
        // Inserting Row
        db.insert(TABLE_LAWS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    //CNR MODULE

    Laws getMod1(String cnr, String year){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(true,TABLE_LAWS, new String[] {KEY_CNR,
                        KEY_CASETYPE, KEY_ADVOCATE , KEY_DISTRICT ,KEY_TYPEOFCOURT , KEY_ACT,
                        KEY_PARTYNAME , KEY_CASESTATUS,KEY_COURTNAME ,KEY_DATE ,
                        KEY_YEAR,KEY_REGDATE,KEY_SECTION }, KEY_CNR + "=?"+ " AND " +  KEY_YEAR+ "=?",
                new String[] { cnr,year}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        if(cursor.getCount()>0)
        {
            Laws a = new Laws(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),cursor.getString(3),
                    cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12) );
            return a;
        }
        else
        {
            return null;
        }


    }

    //MYCASES MODULE

    Laws getMod2(String partyname, String courtname){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LAWS, new String[] {KEY_CNR,
                        KEY_CASETYPE, KEY_ADVOCATE , KEY_DISTRICT ,KEY_TYPEOFCOURT , KEY_ACT,
                        KEY_PARTYNAME , KEY_CASESTATUS,KEY_COURTNAME ,KEY_DATE ,
                        KEY_YEAR,KEY_REGDATE,KEY_SECTION }, KEY_PARTYNAME + "=?" + " AND " +  KEY_COURTNAME + "=?",
                new String[] { partyname,courtname }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        if(cursor.getCount()>0)
        {
            Laws a = new Laws(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),cursor.getString(3),
                    cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12) );
            return a;
        }
        else
        {
            return null;
        }
    }

    //CASE STATUS MODULE

    Laws getMod3(String partyname, String advocate){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LAWS, new String[] {KEY_CNR,
                        KEY_CASETYPE, KEY_ADVOCATE , KEY_DISTRICT ,KEY_TYPEOFCOURT , KEY_ACT,
                        KEY_PARTYNAME , KEY_CASESTATUS,KEY_COURTNAME ,KEY_DATE ,
                        KEY_YEAR,KEY_REGDATE,KEY_SECTION }, KEY_PARTYNAME + "=?" + " AND " +  KEY_ADVOCATE + "=?",
                new String[] {partyname, advocate }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if(cursor.getCount()>0)
        {
            Laws a = new Laws(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),cursor.getString(3),
                    cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12) );
            return a;
        }
        else
        {
            return null;
        }
    }


    //CAUSELIST MODULE

    Laws getMod4(String cnr, String date, String casestatus){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LAWS, new String[] {KEY_CNR,
                        KEY_CASETYPE, KEY_ADVOCATE , KEY_DISTRICT ,KEY_TYPEOFCOURT , KEY_ACT,
                        KEY_PARTYNAME , KEY_CASESTATUS,KEY_COURTNAME ,KEY_DATE ,
                        KEY_YEAR,KEY_REGDATE,KEY_SECTION }, KEY_CNR + "=?" + " AND " +  KEY_CASESTATUS + "=?" + " AND " +  KEY_CASETYPE + "=?",
                new String[] { cnr,date,casestatus }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        if(cursor.getCount()>0)
        {
            Laws a = new Laws(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),cursor.getString(3),
                    cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12) );
            return a;
        }
        else
        {
            return null;
        }
    }

    // MODIFY MODULE

    public int updateLaws(Laws law) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PARTYNAME, law.getPartyname());
        values.put(KEY_CASESTATUS, law.getCaseStatus());
        values.put(KEY_TYPEOFCOURT, law.getTypeofcourt());

        // updating row
        return db.update(TABLE_LAWS, values, KEY_PARTYNAME + " = ?",
                new String[] { String.valueOf(law.getPartyname()) });
    }


    //SEARCH MODULE

    Laws searchMod(String cnr, String year){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(true,TABLE_LAWS, new String[] {KEY_CNR,
                        KEY_CASETYPE, KEY_ADVOCATE , KEY_DISTRICT ,KEY_TYPEOFCOURT , KEY_ACT,
                        KEY_PARTYNAME , KEY_CASESTATUS,KEY_COURTNAME ,KEY_DATE ,
                        KEY_YEAR,KEY_REGDATE,KEY_SECTION }, KEY_CNR + "=?"+ " AND " +  KEY_YEAR+ "=?",
                new String[] { cnr,year}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        if(cursor.getCount()>0)
        {
            Laws a = new Laws(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),cursor.getString(3),
                    cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12) );
            return a;
        }
        else
        {
            return null;
        }


    }


    public void laws(Laws laws) {
    }

}
