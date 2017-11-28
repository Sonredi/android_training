package com.example.aptivist_u002.a11072017crashreportingsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.a_main_btn1);

        button.setOnClickListener(v -> throwException());
    }

    private void throwException() {
        int value = 5 / 0;
    }
}
