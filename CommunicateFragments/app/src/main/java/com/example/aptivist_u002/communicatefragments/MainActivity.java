package com.example.aptivist_u002.communicatefragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnCallbackClicked {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.a_main_tv);
    }

    public void setTextDate(String date){
        textView.setText(date);
    }


    @Override
    public void onCLick(String message) {
        setTextDate(message);
    }
}
