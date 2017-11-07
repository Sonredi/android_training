package com.example.aptivist_u002.a10262017dagger2sample.di;

import android.content.Context;

import com.example.aptivist_u002.a10262017dagger2sample.PreferencesHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */
@Module
public class PreferencesModule {

    private Context context;

    public PreferencesModule(Context context) {
        this.context = context;
    }

    @Provides
    public PreferencesHelper providePreferencesHelper() {
        return new PreferencesHelper(context);
    }

}
