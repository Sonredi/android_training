package com.example.aptivist_u002.a10272017projectintegration.di;

import com.example.aptivist_u002.a10272017projectintegration.data.EarthquakeRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

@Singleton
@Component(modules = {NetworkModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    EarthquakeRepository earthquakeRepository();

}
