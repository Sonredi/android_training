package com.example.aptivist_u002.a10222017_servicessample;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Aptivist-U002 on 10/22/2017.
 */

public class IntentService extends android.app.IntentService {


    private static final String TAG = "IntentServiceTAG_";

    public IntentService() {
        super("intentServiceThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + Thread.currentThread() );
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: " + Thread.currentThread());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: " + Thread.currentThread());
        return super.onBind(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: " +  Thread.currentThread());

    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: " + Thread.currentThread());
        super.onDestroy();
    }
}
