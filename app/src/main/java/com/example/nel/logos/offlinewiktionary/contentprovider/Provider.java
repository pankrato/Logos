package com.example.nel.logos.offlinewiktionary.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.nel.logos.offlinewiktionary.database.DatabaseHelper;

public class Provider extends ContentProvider{

    private DatabaseHelper mDbHelper;

    private static final int WORDS = 10;
    private static final int WORD_ID = 20;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(Contract.CONTENT_AUTHORITY, Contract.Words.PATH, WORDS);
        sUriMatcher.addURI(Contract.CONTENT_AUTHORITY, Contract.Words.PATH + "/*", WORD_ID);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(Contract.Words.TABLE_NAME);

        switch (sUriMatcher.match(uri)) {
            case WORDS:
                break;
            case WORD_ID:
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
