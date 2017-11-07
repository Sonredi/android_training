package com.example.aptivist_u002.a10222017_servicessample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Aptivist-U002 on 10/22/2017.
 */

public class BoundService extends Service {

    private static final String TAG = "BoundServiceTAG_";
    private IBinder binder = new MyBinder();

    private class MyBinder extends Binder {
        Service getService() {
            return BoundService.this;
        }
    }

    @Override
    public void onCreate() {

        Log.d(TAG, "onCreate: " + Thread.currentThread());
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: " + Thread.currentThread());
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: " + Thread.currentThread());
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: " + Thread.currentThread());
        super.onDestroy();
    }
}
