package com.example.aptivist_u002.a10282017projectintegrationassignment.data;

import com.example.aptivist_u002.a10282017projectintegrationassignment.data.local.LocalDataSource;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.pojo.ResultApi;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.remote.FlickrService;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.remote.RemoteDataSource;

import io.reactivex.Observer;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */

public class FlickRepository {

    private LocalDataSource localDataSource;

    private RemoteDataSource remoteDataSource;

    public FlickRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public void retrieveFlickInfo(String tag, Observer<ResultApi> observer) {
        remoteDataSource.retrieveFlickInfo(tag, observer);
    }
}
