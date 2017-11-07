package com.example.aptivist_u002.a10232017localbroadcastassignment;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by Aptivist-U002 on 10/23/2017.
 */

public class CustomBroadcast extends Service {

    private static final String TAG = "CustomBroadcastTAG_";

    public CustomBroadcast(){

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                sendMessage(intent.getStringExtra("value").toString());
            }
        };
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendMessage(String name) {

        while (true){
            try {
                Log.d(TAG, "sendMessage: " +name);

                Intent intent = new Intent("broadcast-btw-app");
                // You can also include some extra data.
                intent.putExtra("value", name);
                //LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                sendBroadcast(intent);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

    }
}
