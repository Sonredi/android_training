package com.example.aptivist_u002.a10232017localbroadcastassignment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAg_";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frame1, new FirstFragment(), "FIRST_FRAGMENT").commit();

        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frame2, new SecondFragment(), "SECOND_FRAGMENT").commit();

    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent(this, CustomBroadcast.class);
        intent.putExtra("value", "dummyValue");
        startService(intent);
    }
}
