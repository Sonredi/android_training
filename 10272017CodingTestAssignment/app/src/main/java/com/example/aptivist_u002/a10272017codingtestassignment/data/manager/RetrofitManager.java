package com.example.aptivist_u002.a10272017codingtestassignment.data.manager;

import com.example.aptivist_u002.a10272017codingtestassignment.data.pojo.ResultApi;
import com.example.aptivist_u002.a10272017codingtestassignment.ui.main.MainPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public class RetrofitManager {

    private Retrofit retrofit;
    private FlickPhotos flickPhotos;

    interface FlickPhotos {

        @GET("/services/feeds/photos_public" +
                ".gne?nojsoncallback=1&tagmode=any&format=json")
        Call<ResultApi> getPhotos(@Query("tags") String tag);
    }


    public RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.flickr.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        flickPhotos = retrofit.create(FlickPhotos.class);
    }

    public void getResources(String input, final MainPresenter.OnRequestFinishedCallBack onRequestFinishedCallBack) {
        flickPhotos.getPhotos(input).enqueue(new Callback<ResultApi>() {

            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                if (response.isSuccessful()) {
                    ResultApi body = response.body();
                    System.out.println(body.toString());
                    onRequestFinishedCallBack.onBackgroundFinished(body);
                }
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {
                System.out.println("-->" + t.getMessage());
            }
        });
    }

}
