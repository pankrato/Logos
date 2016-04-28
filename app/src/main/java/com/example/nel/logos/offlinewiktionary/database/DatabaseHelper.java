package com.example.nel.logos.offlinewiktionary.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nel.logos.offlinewiktionary.contentprovider.Contract;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "logos_test.db";
    private static final int DB_VERSION = 1;

    public  final String TABLE_NAME_WORD = Contract.Words.TABLE_NAME;

    public final String KEY_ID = "_id";
    public final String KEY_SPELLING = Contract.Words.COLUMN_SPELLING;

    private final String CREATE_WORD_DB = "create table " + TABLE_NAME_WORD + " ("
            + KEY_ID + " integer primary key autoincrement, "
            + KEY_SPELLING + " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_WORD_DB);
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('table')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('lamp')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('mug')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('computer')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('mouse')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('window')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('floor')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('power')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('pad')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('socket')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('cord')");
        db.execSQL("insert into " + TABLE_NAME_WORD + " (" + KEY_SPELLING + ") values ('tea')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_WORD);
        onCreate(db);
    }
}
