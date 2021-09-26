package com.example.foodie.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class ChefDB extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ChefDB.db";

    public ChefDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ChefProfile.Chef.TABLE_NAME + " (" +
                   ChefProfile.Chef._ID + " INTEGER PRIMARY KEY," +
                    ChefProfile.Chef.COLUMN_1 + " TEXT," +
                    ChefProfile.Chef.COLUMN_2 + " TEXT," +
                    ChefProfile.Chef.COLUMN_3 + " TEXT," +
                    ChefProfile.Chef.COLUMN_4+ " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ChefProfile.Chef.TABLE_NAME;

    public long addInfo(String username, String email, String  password, String gender){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ChefProfile.Chef.COLUMN_1, username);
        values.put(ChefProfile.Chef.COLUMN_2, email);
        values.put(ChefProfile.Chef.COLUMN_3, password);
        values.put(ChefProfile.Chef.COLUMN_4, gender);



        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ChefProfile.Chef.TABLE_NAME, null, values);
        return newRowId;

    }

    public Boolean updateInfo(String username, String email, String  password, String gender){
        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(ChefProfile.Chef.COLUMN_2, email);
        values.put(ChefProfile.Chef.COLUMN_3, password);
        values.put(ChefProfile.Chef.COLUMN_4, gender);

        // Which row to update, based on the title
        String selection = ChefProfile.Chef.COLUMN_1+ " LIKE ?";
        String[] selectionArgs = { username };

        int count = db.update(
                ChefProfile.Chef.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count>=1){
            return true;
        }
        else {
            return false;
        }
    }

    public void deleteInfo(String username){
        SQLiteDatabase db = getWritableDatabase();
        // Define 'where' part of query.
        String selection = ChefProfile.Chef.COLUMN_1+ " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { "MyTitle" };
        // Issue SQL statement.
        int deletedRows = db.delete(ChefProfile.Chef.TABLE_NAME, selection, selectionArgs);

    }

    public List readAllInfo(String username){

        SQLiteDatabase db =getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                ChefProfile.Chef.COLUMN_1,
                ChefProfile.Chef.COLUMN_2,
                ChefProfile.Chef.COLUMN_3,
                ChefProfile.Chef.COLUMN_4,
        };

// Filter results WHERE "title" = 'My Title'
        String selection = ChefProfile.Chef.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = {username};

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                ChefProfile.Chef.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                ChefProfile.Chef.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
               selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
           String user = cursor.getString(cursor.getColumnIndexOrThrow(ChefProfile.Chef.COLUMN_1));
           String email = cursor.getString(cursor.getColumnIndexOrThrow(ChefProfile.Chef.COLUMN_2));
           String pass= cursor.getString(cursor.getColumnIndexOrThrow(ChefProfile.Chef.COLUMN_3));
           String gender = cursor.getString(cursor.getColumnIndexOrThrow(ChefProfile.Chef.COLUMN_4));

           userInfo.add(user);
           userInfo.add(email);
           userInfo.add(pass);
           userInfo.add(pass);
           userInfo.add(gender);
        }
        cursor.close();
        return userInfo;
    }

}