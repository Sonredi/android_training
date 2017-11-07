package com.example.aptivist_u002.a10272017codingtestassignment.ui.main;

import android.util.Log;

import com.example.aptivist_u002.a10272017codingtestassignment.data.manager.RetrofitManager;
import com.example.aptivist_u002.a10272017codingtestassignment.data.pojo.ResultApi;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenterTAG_";
    private MainContract.View view;

    public interface OnRequestFinishedCallBack {
        void onBackgroundFinished(ResultApi results);
    }

    public MainPresenter() {

    }
    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void dettachView() {
        view = null;
    }

    @Override
    public void loadData(String input) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.getResources(input, new OnRequestFinishedCallBack() {
            @Override
            public void onBackgroundFinished(ResultApi results) {
                view.showResults(results.getItems());
            }
        });
    }
}
