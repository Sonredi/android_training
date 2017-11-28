package com.jacp.a11152017redditassignment.data;

import com.jacp.a11152017redditassignment.data.model.Post;
import com.jacp.a11152017redditassignment.data.remote.RemoteDataSource;

import java.util.List;

import io.reactivex.SingleObserver;

/**
 * Created by Aptivist-U002 on 11/15/2017.
 */

public class RedditRepository {

    private RemoteDataSource remoteDataSource;

    public RedditRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void retrieveAllPosts(SingleObserver<List<Post>> observer) {
        remoteDataSource.retrieveAllPosts(observer);
    }
}
