package com.jacp.a11152017redditassignment.di;

import com.jacp.a11152017redditassignment.data.remote.RedditService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aptivist-U002 on 11/15/2017.
 */
@Module
public class NetworkModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(RedditService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    RedditService provideRedditService(Retrofit retrofit) {
        return retrofit.create(RedditService.class);
    }
}
