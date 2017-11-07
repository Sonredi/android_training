package com.example.aptivist_u002.a10232017httprequestnative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDownload();
    }
}
