package com.example.aptivist_u002.a10262017dagger2sample.di;

import android.content.Context;

import com.example.aptivist_u002.a10262017dagger2sample.DateHelper;
import com.example.aptivist_u002.a10262017dagger2sample.PreferencesHelper;

import java.security.PrivateKey;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

@Module
public class MainModule {

    @Provides
    public DateHelper provideDateHelper() {
        return new DateHelper();
    }
}
