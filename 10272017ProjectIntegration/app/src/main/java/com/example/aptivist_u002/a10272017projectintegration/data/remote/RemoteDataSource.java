package com.example.aptivist_u002.a10272017projectintegration.data.remote;

import com.example.aptivist_u002.a10272017projectintegration.data.pojo.ResultApi;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public class RemoteDataSource {
    private EarthquakeService earthquakeService;

    public RemoteDataSource(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    public void retrieveEarthquake(String startDate, String endDate, Observer<ResultApi> observer) {
        earthquakeService.retrieveEarthquakes(startDate, endDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
