package com.example.nel.logos.offlinewiktionary.contentprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class Contract {

    private Contract() {}

    public static final String CONTENT_AUTHORITY = "com.example.nel.logos.offlinewiktionary.contentprovider.Provider";
    public static final Uri BASE_CONTENT_URI =  Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final class Words implements BaseColumns {

        private static final String TAG = "words";

        public static final String TABLE_NAME = TAG;
        public static final String COLUMN_SPELLING = "spelling";

        public static final String PATH = TAG;

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + PATH;

        public static final String[] DEFAULT_PROJECTION = new String[] {
                Contract.Words._ID,
                Contract.Words.COLUMN_SPELLING};
        public static final String DEFAULT_SORT_ORDER = COLUMN_SPELLING + " ASC";
    }
}
