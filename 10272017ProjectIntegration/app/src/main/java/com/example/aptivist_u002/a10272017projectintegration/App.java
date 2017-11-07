package com.example.aptivist_u002.a10272017projectintegration;

import android.app.Application;

import com.example.aptivist_u002.a10272017projectintegration.di.ApplicationComponent;
import com.example.aptivist_u002.a10272017projectintegration.di.DaggerApplicationComponent;
import com.example.aptivist_u002.a10272017projectintegration.di.NetworkModule;
import com.example.aptivist_u002.a10272017projectintegration.di.RepositoryModule;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
        .repositoryModule(new RepositoryModule())
        .networkModule(new NetworkModule())
        .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
