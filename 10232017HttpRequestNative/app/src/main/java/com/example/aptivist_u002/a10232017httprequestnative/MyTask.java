package com.example.aptivist_u002.a10232017httprequestnative;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Aptivist-U002 on 10/23/2017.
 */

public class MyTask extends AsyncTask<String, Void, Void> {

    private static final String TAG = "AsynckTaskTAG_";

    @Override
    protected Void doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream intputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            Scanner scanner = new Scanner(intputStream);
            while (scanner.hasNextLine()) {
                Log.d(TAG, "httpNative: " + scanner.nextLine());
            }

        } catch (IOException e) {

        }
        return null;
    }
}
