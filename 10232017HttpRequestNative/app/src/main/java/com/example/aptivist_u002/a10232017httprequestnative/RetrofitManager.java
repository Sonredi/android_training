package com.example.aptivist_u002.a10232017httprequestnative;

import android.util.Log;

import com.example.aptivist_u002.a10232017httprequestnative.POJO.Result;
import com.example.aptivist_u002.a10232017httprequestnative.POJO.ResultApi;

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
 * Created by Aptivist-U002 on 10/23/2017.
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

        @GET("/{results}/api")
        Call<ResultApi> getRandomPathCallable(@Path("results") String results);
    }

    public RetrofitManager(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        randomUserService = retrofit.create(RandomUserService.class);
    }

    public void initDownload() {
        randomUserService.getRandomUserCallable().enqueue(new Callback<ResultApi>() {
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                printResultsHttp(response);
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    public void initDownload(int results) {
        randomUserService.getRandomListCallable(results).enqueue(new Callback<ResultApi>() {
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                printResultsHttp(response);
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {

            }
        });
    }

    private void printResultsHttp(Response<ResultApi> response) {
        if (response.isSuccessful()) {
            ResultApi body = response.body();
            System.out.println(body);
            for (Result result : body.getResults()) {
                System.out.println(result);
            }
        }
    }

}
