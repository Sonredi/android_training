package com.example.aptivist_u002.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aptivist-U002 on 10/9/2017.
 */

public interface GitHubClient {

    @GET("users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user")String user);
}
