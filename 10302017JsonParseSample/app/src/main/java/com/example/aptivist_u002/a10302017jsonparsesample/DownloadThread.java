package com.example.aptivist_u002.a10302017jsonparsesample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Aptivist-U002 on 10/30/2017.
 */

public class DownloadThread extends Thread {

    private static final String API_URL = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";
    private static final String TAG = "DownloadThreadTAG_";

    private Handler handler;
    public DownloadThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        try {
            String string = okHttpClient.newCall(request).execute().body().string();
            Log.d(TAG, "run: " + string);
            Bundle bundle = new Bundle();
            bundle.putString("MY_KEY", string);
            Message message = new Message();
            message.setData(bundle);
            handler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
