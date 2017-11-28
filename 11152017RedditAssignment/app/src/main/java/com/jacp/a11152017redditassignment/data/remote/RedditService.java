package com.jacp.a11152017redditassignment.data.remote;

import com.jacp.a11152017redditassignment.data.model.Post;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Aptivist-U002 on 11/15/2017.
 */

public interface RedditService {

    String BASE_URL = "http://10.0.2.2:3000/";

    @GET("/posts")
    Single<List<Post>> retrieveAllPosts();


}
