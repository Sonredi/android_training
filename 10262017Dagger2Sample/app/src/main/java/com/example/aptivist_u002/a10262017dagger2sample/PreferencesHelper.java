package com.example.aptivist_u002.a10262017dagger2sample;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public class PreferencesHelper {
    private Context context;

    public PreferencesHelper(Context context){
        this.context = context;
    }

    public void saveString(String input) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("MY_KEY", input);
        editor.commit();
    }

    public String loadString() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String id = sharedPreferences.getString("MY_KEY", "NA");
        return id;
    }
}
