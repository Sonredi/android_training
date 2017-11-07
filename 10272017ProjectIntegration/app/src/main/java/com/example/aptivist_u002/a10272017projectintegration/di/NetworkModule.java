package com.example.aptivist_u002.a10272017projectintegration.di;

import com.example.aptivist_u002.a10272017projectintegration.data.remote.EarthquakeService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

@Module
public class NetworkModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(EarthquakeService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    EarthquakeService provideEarthquakeService(Retrofit retrofit) {
        return retrofit.create(EarthquakeService.class);
    }
}
