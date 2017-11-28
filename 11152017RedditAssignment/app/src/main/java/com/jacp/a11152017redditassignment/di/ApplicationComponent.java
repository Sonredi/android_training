package com.jacp.a11152017redditassignment.di;

import com.jacp.a11152017redditassignment.data.RedditRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aptivist-U002 on 11/15/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    RedditRepository redditRepository();
}
