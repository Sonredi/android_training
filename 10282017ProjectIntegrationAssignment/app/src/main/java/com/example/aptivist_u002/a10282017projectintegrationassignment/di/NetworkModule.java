package com.example.aptivist_u002.a10282017projectintegrationassignment.di;


import com.example.aptivist_u002.a10282017projectintegrationassignment.data.remote.FlickrService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */

@Module
public class NetworkModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(FlickrService.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    FlickrService provideFlickrService(Retrofit retrofit) {
        return retrofit.create(FlickrService.class);
    }
}
