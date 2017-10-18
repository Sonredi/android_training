package com.example.aptivist_u002.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    private static final String TAG = "SecondActivityTAG_";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");

        Intent intent = getIntent();
        String date = intent.getStringExtra("MY_KEY");

        textView = (TextView) findViewById(R.id.a_second_tv);
        textView.setText(date);
        Log.d(TAG, "onCreate: MY_KEY value is " + date);
    }
}
