package com.jacp.a11152017redditassignment.ui.main;

import com.jacp.a11152017redditassignment.data.RedditRepository;
import com.jacp.a11152017redditassignment.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U002 on 11/16/2017.
 */
@Module
public class MainModule {

    @ActivityScope
    @Provides
    MainPresenter provideMainPresenter(RedditRepository redditRepository) {
        return new MainPresenter(redditRepository);
    }
}
