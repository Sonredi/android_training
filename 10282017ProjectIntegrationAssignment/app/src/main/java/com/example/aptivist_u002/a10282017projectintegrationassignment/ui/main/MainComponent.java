package com.example.aptivist_u002.a10282017projectintegrationassignment.ui.main;

import com.example.aptivist_u002.a10282017projectintegrationassignment.di.ApplicationComponent;
import com.example.aptivist_u002.a10282017projectintegrationassignment.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = ApplicationComponent.class)
public interface MainComponent {

    void Inject(MainActivity mainActivity);
}
