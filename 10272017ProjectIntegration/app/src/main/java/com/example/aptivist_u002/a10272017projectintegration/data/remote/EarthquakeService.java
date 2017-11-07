package com.example.aptivist_u002.a10272017projectintegration.data.remote;

import com.example.aptivist_u002.a10272017projectintegration.data.pojo.ResultApi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public interface EarthquakeService {
    String BASE_URL = "https://earthquake.usgs.gov/";

    @GET("/fdsnws/event/1/query?format=geojson")
    Observable<ResultApi> retrieveEarthquakes(@Query("starttime") String startTime, @Query("endtime") String endTime);
}
