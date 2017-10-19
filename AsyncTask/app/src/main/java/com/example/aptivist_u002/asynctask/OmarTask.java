package com.example.aptivist_u002.asynctask;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Aptivist-U002 on 10/18/2017.
 */

public class OmarTask extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "OmarTaskTAG_";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: "  + Thread.currentThread());

    }

    @Override
    protected Void doInBackground(Void... params) {
        Log.d(TAG, "doInBackground: " + Thread.currentThread());
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());
    }
}
