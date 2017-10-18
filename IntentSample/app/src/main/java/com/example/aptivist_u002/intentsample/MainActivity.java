package com.example.aptivist_u002.intentsample;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    LinearLayout linearLayout;

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        editText = (EditText) findViewById(R.id.a_main_et);
        String date = new Date().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("MY_KEY", editText.getText().toString());
        startActivity(intent);


        Log.d(TAG, "doMagic: " + intent);
    }

    public void resultMagic(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, 10);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // TODO: 10/16/2017 check requestCode, resultCode 
        Log.d(TAG, "onActivityResult: " + data.getIntExtra("MY_KEY", -1));
        int value = data.getIntExtra("MY_KEY", -1);
        linearLayout = (LinearLayout) findViewById(R.id.mainLayout);

        if (value ==1) {
            linearLayout.setBackgroundColor(Color.parseColor("#EC33FF"));
        } else if (value ==2) {
            linearLayout.setBackgroundColor(Color.GREEN);
        } else if (value ==3) {
            linearLayout.setBackgroundColor(Color.YELLOW);
        }

    }


}
