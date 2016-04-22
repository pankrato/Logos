package com.example.nel.logos;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class LogosLoaderCallbacks implements LoaderManager.LoaderCallbacks<Cursor> {

    Context mContext;
    public static final String QUERY_KEY = "query";

    public LogosLoaderCallbacks(Context context) {
        mContext = context;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String query = args.getString(QUERY_KEY);
        Toast.makeText(mContext, query, Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

}
