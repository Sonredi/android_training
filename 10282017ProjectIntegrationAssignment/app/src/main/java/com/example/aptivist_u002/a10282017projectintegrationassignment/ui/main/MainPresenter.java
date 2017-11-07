package com.example.aptivist_u002.a10282017projectintegrationassignment.ui.main;

import android.util.Log;

import com.example.aptivist_u002.a10282017projectintegrationassignment.data.FlickRepository;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.pojo.ResultApi;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPreseterTAG_";
    private MainContract.View view;

    private FlickRepository flickRepository;
    private CompositeDisposable compositeDisposable;

    public MainPresenter(FlickRepository flickRepository) {
        this.flickRepository = flickRepository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
        compositeDisposable.dispose();
    }

    @Override
    public void loadFlickrInfo() {
        view.showProgress();
        flickRepository.retrieveFlickInfo("jacp", new Observer<ResultApi>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(ResultApi resultApi) {
                view.showResults(resultApi.getItems());
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.toString());
                Log.d(TAG, "onError: ");
                view.hideProgress();
            }

            @Override
            public void onComplete() {
                view.hideProgress();
            }
        });

    }
}
