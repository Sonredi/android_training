package com.example.aptivist_u002.a10272017projectintegration.ui.main;

import com.example.aptivist_u002.a10272017projectintegration.data.EarthquakeRepository;
import com.example.aptivist_u002.a10272017projectintegration.data.pojo.ResultApi;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private EarthquakeRepository earthquakeRepository;
    private MainContract.View view;

    private CompositeDisposable compositeDisposable;

    public MainPresenter(EarthquakeRepository earthquakeRepository) {
        this.earthquakeRepository = earthquakeRepository;

        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onAttachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        view = null;
        compositeDisposable.dispose();
    }

    @Override
    public void loadEarthquakes() {
        view.showProgress();
        earthquakeRepository.retrieveEarthQuakes("2017-10-27", "2017-10-28", new Observer<ResultApi>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(ResultApi resultApi) {
                view.showResults(resultApi.getFeatures());
            }

            @Override
            public void onError(Throwable e) {
                view.ShowError(e.toString());
                view.hideProgress();
            }

            @Override
            public void onComplete() {
                view.hideProgress();
            }
        });
    }
}
