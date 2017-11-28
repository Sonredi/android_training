package com.jacp.a11152017redditassignment;

import android.app.Application;

import com.jacp.a11152017redditassignment.di.ApplicationComponent;
import com.jacp.a11152017redditassignment.di.DaggerApplicationComponent;
import com.jacp.a11152017redditassignment.di.NetworkModule;
import com.jacp.a11152017redditassignment.di.RepositoryModule;

/**
 * Created by Aptivist-U002 on 11/16/2017.
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
