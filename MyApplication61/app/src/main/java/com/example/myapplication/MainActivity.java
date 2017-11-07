package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.managers.OkHttpManager;
import com.example.myapplication.managers.RetrofitManager;
import com.example.myapplication.managers.VolleyManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private static final String API_URL = "https://randomuser.me/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void httpMagic(View view) {
        new MyTask().execute(API_URL);
    }


    public void okHttpMagic(View view) {
        OkHttpManager okHttpManager = new OkHttpManager();
        okHttpManager.initDownload(API_URL);
    }

    public void retrofitMagic(View view) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDownload();
    }

    public void retrofitListMagic(View view) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDownload(11);
    }

    public void listActivityMagic(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    public void volleyMagic(View view) {
        VolleyManager volleyManager = new VolleyManager(this);
        volleyManager.initDownload(API_URL);
    }
}
