package com.example.nel.logos;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.nel.logos.offlinewiktionary.contentprovider.Contract;

public class LogosLoaderCallbacks implements LoaderManager.LoaderCallbacks<Cursor> {

    private Context mContext;
    private SimpleCursorAdapter mAdapter;

    public static final String QUERY_KEY = "query";

    public LogosLoaderCallbacks(Context context) {
        mContext = context;
        String[] from = new String[] { Contract.Words.COLUMN_SPELLING };
        int[] to = new int[] { R.id.word };
        mAdapter = new SimpleCursorAdapter(context, R.layout.word_item, null, from, to, 0);
        ListView lv = (ListView) ((Activity)mContext).findViewById(R.id.words_list);
        lv.setAdapter(mAdapter);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        // Uri uri = Uri.withAppendedPath(Contract.Words.CONTENT_URI, query);
        Uri uri = Contract.Words.CONTENT_URI;
        String selection = Contract.Words.COLUMN_SPELLING + " = ?";
        String[] selArgs = { args.getString(QUERY_KEY) };

        return new CursorLoader(
                mContext,   // Context
                uri,        // URI representing the table/resource to be queried
                null,       // projection - the list of columns to return.  Null means "all"
                selection,       // selection - Which rows to return (condition rows must match)
                selArgs,       // selection args - can be provided separately and subbed into selection.
                Contract.Words.DEFAULT_SORT_ORDER);      // string specifying sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

}
