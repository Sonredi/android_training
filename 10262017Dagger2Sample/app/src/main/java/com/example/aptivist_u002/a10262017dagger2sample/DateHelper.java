package com.example.aptivist_u002.a10262017dagger2sample;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Date;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public class DateHelper {

    public String generateDate() {
        return new Date().toString();
    }

}
