package com.example.aptivist_u002.sharedpreferences;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Aptivist-U002 on 10/18/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
