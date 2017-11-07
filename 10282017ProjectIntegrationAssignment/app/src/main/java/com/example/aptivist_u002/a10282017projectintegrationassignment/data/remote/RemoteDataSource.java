package com.example.aptivist_u002.a10282017projectintegrationassignment.data.remote;

import com.example.aptivist_u002.a10282017projectintegrationassignment.data.pojo.ResultApi;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */

public class RemoteDataSource {
    private FlickrService flickrService;

    public RemoteDataSource(FlickrService flickrService) {
        this.flickrService = flickrService;
    }

    public  void retrieveFlickInfo(String tag, Observer<ResultApi> obsever) {
        flickrService.retrieveFlickrInfo(tag)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(obsever);
    }
}
