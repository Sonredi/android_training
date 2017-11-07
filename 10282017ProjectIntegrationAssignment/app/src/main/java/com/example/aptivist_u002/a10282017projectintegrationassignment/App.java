package com.example.aptivist_u002.a10282017projectintegrationassignment;

import android.app.Application;

import com.example.aptivist_u002.a10282017projectintegrationassignment.di.ApplicationComponent;
import com.example.aptivist_u002.a10282017projectintegrationassignment.di.DaggerApplicationComponent;
import com.example.aptivist_u002.a10282017projectintegrationassignment.di.NetworkModule;
import com.example.aptivist_u002.a10282017projectintegrationassignment.di.RepositoryModule;

/**
 * Created by Aptivist-U002 on 10/28/2017.
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
