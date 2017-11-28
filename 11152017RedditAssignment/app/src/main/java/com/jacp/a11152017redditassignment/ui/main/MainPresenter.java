package com.jacp.a11152017redditassignment.ui.main;

import android.util.Log;

import com.jacp.a11152017redditassignment.data.RedditRepository;
import com.jacp.a11152017redditassignment.data.model.Post;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Aptivist-U002 on 11/16/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenterTAg_";
    private MainContract.View view;
    private RedditRepository redditRepository;
    private CompositeDisposable compositeDisposable;

    public MainPresenter(RedditRepository redditRepository) {
        this.redditRepository = redditRepository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void loadRedditPosts() {
        view.showProgress();
        redditRepository.retrieveAllPosts(new SingleObserver<List<Post>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(List<Post> postList) {
                view.showAllPosts(postList);
                view.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.toString());
                view.hideProgress();
                Log.d(TAG, "onError: " + e.getMessage());
            }

        });
    }
}
