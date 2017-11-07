package com.example.aptivist_u002.a10222017_broadcastreceiversample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView1 = (TextView) findViewById(R.id.second_text);
        Intent intent = getIntent();
        String boo = intent.getStringExtra("AIR");
        textView1.setText(boo);


    }
}
