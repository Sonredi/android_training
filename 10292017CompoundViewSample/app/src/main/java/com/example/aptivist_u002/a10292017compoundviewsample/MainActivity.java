package com.example.aptivist_u002.a10292017compoundviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.a_main_linear);
    }

    public void doMagic(View view) {
        MyCompoundView myCompoundView = new MyCompoundView(this, null);
        linearLayout.addView(myCompoundView);

        myCompoundView.setImage("http://lorempixel.com/400/200/");
    }
}
