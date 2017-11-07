package com.example.aptivist_u002.a10242017databasesample;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Aptivist-U002 on 10/24/2017.
 */

public class App extends Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
