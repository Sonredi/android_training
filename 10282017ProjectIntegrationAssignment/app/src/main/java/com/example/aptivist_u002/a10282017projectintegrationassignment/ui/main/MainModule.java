package com.example.aptivist_u002.a10282017projectintegrationassignment.ui.main;

import com.example.aptivist_u002.a10282017projectintegrationassignment.data.FlickRepository;
import com.example.aptivist_u002.a10282017projectintegrationassignment.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */
@Module
public class MainModule {

    @ActivityScope
    @Provides
    MainPresenter provideMainPresenter(FlickRepository flickRepository) {
        return new MainPresenter(flickRepository);
    }
}
