package com.example.aptivist_u002.a10262017mvpassignment.data.manager;

import com.example.aptivist_u002.a10262017mvpassignment.data.pojo.ResultApi;
import com.example.aptivist_u002.a10262017mvpassignment.ui.main.MainPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public class RetrofitManager {

    private Retrofit retrofit;
    private UserRepos userRepos;

    interface UserRepos {
        @GET("/users/{user}/repos")
        Call<List<ResultApi>> getRepos(@Path("user") String user);
    }

    public RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        userRepos = retrofit.create(UserRepos.class);
    }

    public void getRepos(String user) {
        userRepos.getRepos(user).enqueue(new Callback<List<ResultApi>>() {
            @Override
            public void onResponse(Call<List<ResultApi>> call, Response<List<ResultApi>> response) {
                if (response.isSuccessful()) {
                    List<ResultApi> body = response.body();
                    System.out.println(body.get(0).toString());
                 }
            }

            @Override
            public void onFailure(Call<List<ResultApi>> call, Throwable t) {

            }
        });
    }

    public void getRepos(String user, final MainPresenter.OnRequestFinishedCallback onRequestFinishedCallback) {
        userRepos.getRepos(user).enqueue(new Callback<List<ResultApi>>() {
            @Override
            public void onResponse(Call<List<ResultApi>> call, Response<List<ResultApi>> response) {
                if (response.isSuccessful()) {
                    List<ResultApi> body = response.body();
                    //System.out.println(body.get(0).toString());
                    onRequestFinishedCallback.onRequestFinished(body);
                }
            }

            @Override
            public void onFailure(Call<List<ResultApi>> call, Throwable t) {

            }
        });
    }

}
