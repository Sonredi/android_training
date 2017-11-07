package com.example.aptivist_u002.a10242017retrofitjacksonassignment.Manager;

/**
 * Created by Aptivist-U002 on 10/24/2017.
 */

import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class CacheResponse {
    private final OkHttpClient client;

    public CacheResponse(File cacheDirectory) throws Exception {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(cacheDirectory, cacheSize);

        client = new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response1) throws IOException {

                String response1Body = response1.body().string();
                System.out.println("Response 1 response:          " + response1);
                System.out.println("Response 1 cache response:    " + response1.cacheResponse());
                System.out.println("Response 1 network response:  " + response1.networkResponse());
            }
        });

    }

//    public static void main(String... args) throws Exception {
//        new CacheResponse(new File("CacheResponse.tmp")).run();
//    }
}
