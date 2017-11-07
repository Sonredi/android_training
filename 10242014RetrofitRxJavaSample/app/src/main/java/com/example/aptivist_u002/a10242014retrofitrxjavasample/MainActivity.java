package com.example.aptivist_u002.a10242014retrofitrxjavasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.aptivist_u002.a10242014retrofitrxjavasample.Pojo.Result;
import com.example.aptivist_u002.a10242014retrofitrxjavasample.Pojo.ResultApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private RandomUserService randomUserService;
    private static final String BASE_URL = "https://randomuser.me";



    interface RandomUserService {
        @GET("/api")
        Observable<ResultApi> getRandomUsers(@Query("results") int results);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomUserService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RandomUserService.class);
    }

    public void doMagic(View view) {
        randomUserService.getRandomUsers(10)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::printResult);
    }

    private void printResult(ResultApi resultApi) {
        for (Result result : resultApi.getResults()) {
            Log.d(TAG, "accept: " + result);
        }
    }
}
