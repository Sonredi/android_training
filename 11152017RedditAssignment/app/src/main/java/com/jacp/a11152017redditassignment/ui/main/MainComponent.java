package com.jacp.a11152017redditassignment.ui.main;

import com.jacp.a11152017redditassignment.di.ApplicationComponent;
import com.jacp.a11152017redditassignment.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by Aptivist-U002 on 11/16/2017.
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = ApplicationComponent.class)
public interface MainComponent {

    void Inject(MainFragment mainActivity);
}
