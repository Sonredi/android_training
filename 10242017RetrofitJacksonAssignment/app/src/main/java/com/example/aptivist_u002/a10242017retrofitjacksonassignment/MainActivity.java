package com.example.aptivist_u002.a10242017retrofitjacksonassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.aptivist_u002.a10242017retrofitjacksonassignment.Manager.CacheResponse;
import com.example.aptivist_u002.a10242017retrofitjacksonassignment.Manager.CustomVolleyRequestQueue;
import com.example.aptivist_u002.a10242017retrofitjacksonassignment.Manager.OkHttpManager;
import com.example.aptivist_u002.a10242017retrofitjacksonassignment.Manager.RetrofitManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private NetworkImageView mNetworkImageView;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNetworkImageView = (NetworkImageView) findViewById(R.id
                .networkImageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Instantiate the RequestQueue.
        mImageLoader = CustomVolleyRequestQueue.getInstance(this.getApplicationContext())
                .getImageLoader();
        //Image URL - This can point to any image file supported by Android
        final String url = "http://lorempixel.com/400/200/";
        mImageLoader.get(url, ImageLoader.getImageListener(mNetworkImageView,
                R.mipmap.ic_launcher, android.R.drawable
                        .ic_dialog_alert));
        mNetworkImageView.setImageUrl(url, mImageLoader);
    }

    public void startDownload(View view) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDOwnload(2);

    }

    public void responseCaching(View view) {
//        OkHttpManager okHttpManager = new OkHttpManager();
//        okHttpManager.synchronousGet();


        File file = view.getContext().getCacheDir();
        try {
            CacheResponse cacheResponse = new CacheResponse(file);
            cacheResponse.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
