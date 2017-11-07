package com.example.aptivist_u002.a10232017httprequestnative;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.aptivist_u002.a10232017httprequestnative.managers.VolleyManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static final String API_URL = "https://randomuser.me/api";
    private static final String TAG = "MainActivityTAG_";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    }

    public void httpNative(View view) {
        new MyTask().execute(API_URL);

    }

    public void okHttpConnection(View view) {
        OkHttpManager okHttpManager = new OkHttpManager();
        okHttpManager.initDownload(API_URL);
    }

    public void retrofitConnection(View view) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDownload();

    }

    public void retrofitList(View view) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDownload(10);

    }

    public void showData(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void volleyConnection(View view) {
        VolleyManager volleyManager = new VolleyManager(this);
        volleyManager.initDownload(API_URL);
    }
}
