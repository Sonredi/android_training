package com.example.aptivist_u002.a10272017projectintegration.data;

import com.example.aptivist_u002.a10272017projectintegration.data.local.LocalDataSource;
import com.example.aptivist_u002.a10272017projectintegration.data.pojo.ResultApi;
import com.example.aptivist_u002.a10272017projectintegration.data.remote.RemoteDataSource;

import io.reactivex.Observer;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public class EarthquakeRepository {

    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;

    public EarthquakeRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public void retrieveEarthQuakes(String startDate, String endDate, Observer<ResultApi> observer) {
        // TODO: 10/27/2017 Get earthquakes from the database first
        remoteDataSource.retrieveEarthquake(startDate, endDate, observer);
    }
}
