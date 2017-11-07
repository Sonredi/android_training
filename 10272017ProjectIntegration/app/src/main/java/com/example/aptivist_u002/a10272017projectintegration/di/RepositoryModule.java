package com.example.aptivist_u002.a10272017projectintegration.di;

import com.example.aptivist_u002.a10272017projectintegration.data.EarthquakeRepository;
import com.example.aptivist_u002.a10272017projectintegration.data.local.LocalDataSource;
import com.example.aptivist_u002.a10272017projectintegration.data.remote.EarthquakeService;
import com.example.aptivist_u002.a10272017projectintegration.data.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    EarthquakeRepository provideEarthquakeRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        return new EarthquakeRepository(localDataSource, remoteDataSource);
    }

    @Singleton
    @Provides
    LocalDataSource provideLocalDataSource() {
        return new LocalDataSource();
    }

    @Singleton
    @Provides
    RemoteDataSource provideRemoteDataSource(EarthquakeService earthquakeService) {
        return new RemoteDataSource(earthquakeService);
    }

}
