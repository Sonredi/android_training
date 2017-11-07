package com.example.aptivist_u002.a10312017flavorssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainACtivityTAG_";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.a_main_txt1);

        String flavor = BuildConfig.FLAVOR;
        textView.setText(flavor);

        String apiUrl = BuildConfig.BASE_URL;
        String apiKey = getString(R.string.API_KEY);
        String packageName = getPackageName();

        Log.d(TAG, "onCreate: " + apiUrl +" " + apiKey + " " + packageName);

        LocationHelper.sayHello();
    }
}
