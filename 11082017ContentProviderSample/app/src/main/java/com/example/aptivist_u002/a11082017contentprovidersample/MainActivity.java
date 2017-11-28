package com.example.aptivist_u002.a11082017contentprovidersample;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private Button button;
    private Button buttonRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.a_main_btn);
        buttonRead = findViewById(R.id.a_main_read);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });


        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = getContentResolver().query(MyProvider.CONTENT_URI,
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
    }
}
