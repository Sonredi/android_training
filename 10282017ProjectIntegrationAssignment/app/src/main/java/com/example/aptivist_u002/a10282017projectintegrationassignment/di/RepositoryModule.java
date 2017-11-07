package com.example.aptivist_u002.a10282017projectintegrationassignment.di;

import com.example.aptivist_u002.a10282017projectintegrationassignment.data.FlickRepository;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.local.LocalDataSource;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.remote.FlickrService;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */
@Module
public class RepositoryModule {

    @Singleton
    @Provides
    FlickRepository provideFlickrRepository(LocalDataSource localDataSource,
                                            RemoteDataSource remoteDataSource) {
        return new FlickRepository(localDataSource, remoteDataSource);
    }

    @Singleton
    @Provides
    LocalDataSource provideLocalDataSource() {
        return new LocalDataSource();
    }

    @Singleton
    @Provides
    RemoteDataSource provideRemoteDataSource(FlickrService flickrService) {
        return new RemoteDataSource(flickrService);
    }
}
