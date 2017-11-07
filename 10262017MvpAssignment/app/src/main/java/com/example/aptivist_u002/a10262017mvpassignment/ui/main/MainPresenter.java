package com.example.aptivist_u002.a10262017mvpassignment.ui.main;

import com.example.aptivist_u002.a10262017mvpassignment.data.manager.RetrofitManager;
import com.example.aptivist_u002.a10262017mvpassignment.data.pojo.ResultApi;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public interface OnRequestFinishedCallback {
        void onRequestFinished(List<ResultApi> results);
    }

    public MainPresenter() {
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadData(String user) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.getRepos(user, new OnRequestFinishedCallback() {
            @Override
            public void onRequestFinished(List<ResultApi> results) {
                view.showResults(results);
            }
        });
    }
}
