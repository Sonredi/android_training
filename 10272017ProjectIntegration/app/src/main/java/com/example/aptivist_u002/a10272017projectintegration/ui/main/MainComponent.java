package com.example.aptivist_u002.a10272017projectintegration.ui.main;

import com.example.aptivist_u002.a10272017projectintegration.di.ApplicationComponent;
import com.example.aptivist_u002.a10272017projectintegration.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = ApplicationComponent.class)
public interface MainComponent {

    void Inject(MainActivity mainActivity);
}
