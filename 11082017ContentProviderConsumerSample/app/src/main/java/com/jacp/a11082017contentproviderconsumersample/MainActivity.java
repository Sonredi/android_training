package com.jacp.a11082017contentproviderconsumersample;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String AUTHORITY = "com.example.jacp.provider";//the package by convention
    private static final String BASE_URI = "content://";//the package by convention

    public static final Uri CONTENT_URI = Uri.parse(BASE_URI + AUTHORITY);
    private static final String TAG = "MainActivityTAG_";

    private Button consumeContent;
    private Button btnLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consumeContent = findViewById(R.id.a_main_btn_consume);

        consumeContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = getContentResolver().query(CONTENT_URI,
                        null, null, null, null);

                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        String id = cursor.getString(0);
                        String name = cursor.getString(1);
                        String age = cursor.getString(2);
                        Log.d(TAG, "onClick: " + id + " " + name + " " + age);

                    } while (cursor.moveToNext());
                    cursor.close();
                }
            }
        });



        btnLoader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoaderActivity.class);
                startActivity(intent);
            }
        });
    }
}
