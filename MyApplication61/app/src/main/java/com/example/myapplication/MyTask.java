package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by user on 10/23/17.
 */

public class MyTask extends AsyncTask<String, Void, Void> {

    private static final String TAG = "MyTaskTAG_";

    @Override
    protected Void doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                Log.d(TAG, "httpMagic: " + scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
