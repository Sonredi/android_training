package com.example.aptivist_u002.a10262017dagger2sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.aptivist_u002.a10262017dagger2sample.di.DaggerMainComponent;
import com.example.aptivist_u002.a10262017dagger2sample.di.MainModule;
import com.example.aptivist_u002.a10262017dagger2sample.di.PreferencesModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    @Inject
    DateHelper dateHelper;

    @Inject
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .preferencesModule(new PreferencesModule(this))
                .build()
                .inject(this);
    }

    public void doMagic(View view) {
        Log.d(TAG, "doMagic: " + dateHelper.generateDate());

        preferencesHelper.saveString("joseCruz");
        Log.d(TAG, "doMagic: " + preferencesHelper.loadString());
    }
}
