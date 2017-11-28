package com.jacp.a11082017contentproviderconsumersample;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LoaderActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final String AUTHORITY = "com.example.jacp.provider";//the package by convention
    private static final String BASE_URI = "content://";//the package by convention

    public static final Uri CONTENT_URI = Uri.parse(BASE_URI + AUTHORITY);
    private static final String TAG = "LoaderActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        getSupportLoaderManager().initLoader(10, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, CONTENT_URI,
                null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String age = cursor.getString(2);
                Log.d(TAG, "onClick: " + id + " " + name + " " + age);

            } while (cursor.moveToNext());
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
