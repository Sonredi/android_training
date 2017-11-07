package com.example.aptivist_u002.a10222017_servicessample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class StartedService extends Service {
    private static final String TAG = "StartedServiceTAG_";

    public StartedService() {
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand: ");

        if (intent.getStringExtra("name").equals("edwin")) {
            stopSelf();

        } else {
            Log.d(TAG, "onStartCommand: " + intent.getStringExtra("name").toString() + " thread" + Thread.currentThread());
        }
        return super.onStartCommand(intent, flags, startId);
        
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind: ");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        
    }
}
