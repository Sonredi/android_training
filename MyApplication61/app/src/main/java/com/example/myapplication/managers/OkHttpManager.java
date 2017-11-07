package com.example.myapplication.managers;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by user on 10/23/17.
 */

public class OkHttpManager {
    // OkHTTPManager

    private OkHttpClient okHttpClient;

    public OkHttpManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    public void initDownload(String url) {
        Request request = new Request.Builder()
                .url(url)
//                .addHeader("API_KEY", "ABC")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
//                throw new RuntimeException(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
                System.out.println(response.code());
            }
        });
    }
}
