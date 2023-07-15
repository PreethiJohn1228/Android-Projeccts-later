package com.example.ex5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LibraryManager";
    private static final String TABLE_BOOKS = "Books";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_PRICE = "price";
    private static final String KEY_BORROWDATE = "borrowdate";
    private static final String KEY_RETURNDATE = "returndate";
    private static final String KEY_GENRE = "genre";
    

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE = "CREATE TABLE " + TABLE_BOOKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"+ KEY_AUTHOR + " TEXT,"+
                KEY_PRICE + " TEXT,"+ KEY_BORROWDATE + " TEXT,"+ KEY_RETURNDATE + " TEXT,"
                + KEY_GENRE + " TEXT" + ")";
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);

    }
    void addBook(Books books) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, books.getTitle());
        values.put(KEY_AUTHOR, books.getAuthor());
        values.put(KEY_PRICE, books.getPrice());
        values.put(KEY_BORROWDATE, books.getBorrowdate());
        values.put(KEY_RETURNDATE, books.getReturndate());
        values.put(KEY_GENRE, books.getGenre());
        // Inserting Row
        db.insert(TABLE_BOOKS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    Books getBooks(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BOOKS, new String[] { KEY_ID,
                        KEY_TITLE, KEY_AUTHOR,KEY_PRICE,KEY_BORROWDATE,KEY_RETURNDATE,KEY_GENRE}, KEY_TITLE + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        if(cursor.getCount()>0)
        {
            Books a = new Books(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),Integer.parseInt(cursor.getString(3)),
                    cursor.getString(4), cursor.getString(5),
                    cursor.getString(6));
            return a;
        }
        else
        {
            return null;
        }
    }
    public int updateBooks(Books contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, contact.getTitle());
        values.put(KEY_AUTHOR, contact.getAuthor());
        values.put(KEY_PRICE, contact.getPrice());
        values.put(KEY_BORROWDATE, contact.getBorrowdate());
        values.put(KEY_RETURNDATE, contact.getReturndate());
        values.put(KEY_GENRE, contact.getGenre());
        // updating row
        return db.update(TABLE_BOOKS, values, KEY_TITLE + " = ?",
                new String[] { String.valueOf(contact.getTitle()) });
    }
    public void deleteBooks(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOKS, KEY_TITLE + " = ?",
                new String[] { String.valueOf(name) });
        db.close();
    }

    public void books(Books books) {
    }
}
