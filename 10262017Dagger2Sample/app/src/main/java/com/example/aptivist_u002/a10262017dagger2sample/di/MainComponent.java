package com.example.aptivist_u002.a10262017dagger2sample.di;

import com.example.aptivist_u002.a10262017dagger2sample.MainActivity;

import dagger.Component;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */
@Component(modules = {MainModule.class, PreferencesModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
