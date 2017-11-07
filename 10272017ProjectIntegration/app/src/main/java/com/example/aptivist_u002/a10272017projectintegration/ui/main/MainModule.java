package com.example.aptivist_u002.a10272017projectintegration.ui.main;

import com.example.aptivist_u002.a10272017projectintegration.data.EarthquakeRepository;
import com.example.aptivist_u002.a10272017projectintegration.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */
@Module
public class MainModule {

    @ActivityScope
    @Provides
    MainPresenter provideMainPresenter(EarthquakeRepository earthquakeRepository) {
        return new MainPresenter(earthquakeRepository);
    }
}
