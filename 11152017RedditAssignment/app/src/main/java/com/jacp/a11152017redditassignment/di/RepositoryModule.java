package com.jacp.a11152017redditassignment.di;

import com.jacp.a11152017redditassignment.data.RedditRepository;
import com.jacp.a11152017redditassignment.data.remote.RedditService;
import com.jacp.a11152017redditassignment.data.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U002 on 11/15/2017.
 */
@Module
public class RepositoryModule {

    @Singleton
    @Provides
    RedditRepository provideRedditRepository(RemoteDataSource remoteDataSource) {
        return new RedditRepository(remoteDataSource);
    }

    @Singleton
    @Provides
    RemoteDataSource provideRemoteDataSource(RedditService redditService) {
        return new RemoteDataSource(redditService);
    }
}
