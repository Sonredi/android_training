package com.example.aptivist_u002.a10282017projectintegrationassignment.di;

import com.example.aptivist_u002.a10282017projectintegrationassignment.data.FlickRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    FlickRepository flickrRepository();
}
