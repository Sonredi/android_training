package com.example.aptivist_u002.a10242017retrofitjacksonassignment.Manager;

import com.example.aptivist_u002.a10242017retrofitjacksonassignment.Pojo.Result;
import com.example.aptivist_u002.a10242017retrofitjacksonassignment.Pojo.ResultApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Aptivist-U002 on 10/24/2017.
 */

public class RetrofitManager {

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


    public RetrofitManager() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(JacksonConverterFactory.create()).build();

        randomUserService = retrofit.create(RandomUserService.class);

    }

    public void initDOwnload(int results) {
        randomUserService.getRandomListCallable(results).enqueue(new Callback<ResultApi>() {
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                if (response.isSuccessful()) {
                    ResultApi body = response.body();
                    System.out.println(body);
                    for (Result result : body.getResults()) {
                        System.out.println(result);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
