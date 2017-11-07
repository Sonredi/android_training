package com.example.aptivist_u002.a10282017projectintegrationassignment.data.remote;

import com.example.aptivist_u002.a10282017projectintegrationassignment.data.pojo.ResultApi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */

public interface FlickrService {

    String BASE_URL = "http://api.flickr.com";

    @GET("/services/feeds/photos_public.gne?nojsoncallback=1" +
            "&tagmode=any&format=json")
    Observable<ResultApi> retrieveFlickrInfo(@Query("tags") String tag);
}
