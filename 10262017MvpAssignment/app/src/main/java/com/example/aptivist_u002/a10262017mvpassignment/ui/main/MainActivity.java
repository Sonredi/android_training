package com.example.aptivist_u002.a10262017mvpassignment.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.aptivist_u002.a10262017mvpassignment.R;
import com.example.aptivist_u002.a10262017mvpassignment.data.pojo.ResultApi;
import com.example.aptivist_u002.a10262017mvpassignment.ui.calculator.CalculatorActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private static final String TAG = "MainActivityTAG_";
    private MainPresenter mainPresenter;
    private EditText editText;

    private RecyclerView recyclerView;
    private MinimalAdapter minimalAdapter;
    private List<ResultApi> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.a_main_eText1);
        editText.setText("aguilaj10");
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);

        resultList = new ArrayList<>();
        minimalAdapter = new MinimalAdapter(resultList);

        recyclerView = (RecyclerView) findViewById(R.id.a_details_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(minimalAdapter);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showResults(List<ResultApi> result) {
        Log.d(TAG, "showResults: ResultApi" + result.toString());
        resultList.clear();
        resultList.addAll(result);
        minimalAdapter.notifyDataSetChanged();
    }

    public void loadRepos(View view) {
        mainPresenter.loadData(editText.getText().toString());
    }

    public void goCalculator(View view) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }
}
