package com.example.aptivist_u002.a11082017contentprovidersample;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Arrays;

/**
 * Created by Aptivist-U002 on 11/8/2017.
 */

public class MyProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.jacp.provider";//the package by convention
    private static final String BASE_URI = "content://";//the package by convention

    public static final Uri CONTENT_URI = Uri.parse(BASE_URI + AUTHORITY);
    private static final String TAG = "MyProviderTAG_";

    public MyProvider() {
        Log.d(TAG, "MyProvider: ");
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate: ");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Log.d(TAG, "query: ");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_ID", "NAME", "AGE"});
        matrixCursor.addRow(Arrays.asList("1", "jacp", "27"));
        matrixCursor.addRow(Arrays.asList("2", "jose", "27"));
        matrixCursor.addRow(Arrays.asList("3", "anton", "27"));
        matrixCursor.addRow(Arrays.asList("4", "josh", "27"));
        matrixCursor.addRow(Arrays.asList("5", "cruz", "27"));

        return matrixCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Log.d(TAG, "getType: ");
        return ContentResolver.CURSOR_DIR_BASE_TYPE;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.d(TAG, "insert: ");
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        Log.d(TAG, "delete: ");
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        Log.d(TAG, "update: ");
        return 0;
    }
}
