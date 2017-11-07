package com.example.myapplication.managers;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.myapplication.DetailsActivity;
import com.example.myapplication.entities.Result;
import com.example.myapplication.entities.ResultApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by user on 10/23/17.
 */

public class RetrofitManager {

    private static final String TAG = "RetrofitManagerTAG_";

    private Retrofit retrofit;
    private RandomUserService randomUserService;

    interface RandomUserService {
        @GET("/api")
        Call<ResultApi> getRandomUserCallable();

        @GET("/api")
        Call<ResultApi> getRandomListCallable(@Query("results") int results);
        //  https://randomuser.me/ + /api + ?results=11
        //  https://randomuser.me/api?results=11

        @GET("/{results}/api")
        Call<ResultApi> getRandomPathCallable(@Path("results") String results);
        //  https://randomuser.me/ + /11/api
        //  https://randomuser.me/11/api

    }

    public RetrofitManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        randomUserService = retrofit.create(RandomUserService.class);
    }

    public void initDownload() {
        randomUserService.getRandomUserCallable().enqueue(generateCallback());
    }

    public void initDownload(int results) {
        randomUserService.getRandomListCallable(results).enqueue(generateCallback());
    }

    public void initDownload(int results, final DetailsActivity.OnRequestFinishedCallback onRequestFinishedCallback) {
        randomUserService.getRandomListCallable(results).enqueue(new Callback<ResultApi>() {
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                Log.d(TAG, "onResponse: RetrofitManager");
                onRequestFinishedCallback.onRequestFinished(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {

            }
        });
    }


    @NonNull
    private Callback<ResultApi> generateCallback() {
        return new Callback<ResultApi>() {
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                printResults(response);
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {
                t.printStackTrace();
            }
        };
    }

    private void printResults(Response<ResultApi> response) {
        if (response.isSuccessful()) {
            ResultApi body = response.body();
            System.out.println(body);

            for (Result result : body.getResults()) {
                System.out.println(result);
            }
        }
    }
}
