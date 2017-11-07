package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.myapplication.entities.Result;
import com.example.myapplication.managers.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivityTAG_";

    public interface OnRequestFinishedCallback {
        void onRequestFinished(List<Result> results);
    }

    private RecyclerView recyclerView;
    private MinimalAdapter minimalAdapter;
    private List<Result> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        resultList = new ArrayList<>();
        minimalAdapter = new MinimalAdapter(resultList);

        recyclerView = (RecyclerView) findViewById(R.id.a_details_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(minimalAdapter);

        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDownload(11, new OnRequestFinishedCallback() {

            @Override
            public void onRequestFinished(List<Result> results) {
                Log.d(TAG, "onRequestFinished: ");
                resultList.clear();
                resultList.addAll(results);
                minimalAdapter.notifyDataSetChanged();
            }
        });

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://randomuser.me/")
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RetrofitManager.RandomUserService randomUserService = retrofit.create(RetrofitManager.RandomUserService.class);
//        randomUserService.getRandomListCallable(11).enqueue(new Callback<ResultApi>() {
//            @Override
//            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
//                resultList.clear();
//                resultList.addAll(response.body().getResults());
//                minimalAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<ResultApi> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }
}
