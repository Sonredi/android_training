package com.jacp.a11152017redditassignment.data.remote;

import com.jacp.a11152017redditassignment.data.model.Post;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aptivist-U002 on 11/15/2017.
 */

public class RemoteDataSource {

    private RedditService redditService;

    public RemoteDataSource(RedditService redditService) {
        this.redditService = redditService;
    }

    public void retrieveAllPosts(SingleObserver<List<Post>> observer) {
        redditService.retrieveAllPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
