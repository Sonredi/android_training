package com.example.aptivist_u002.a10272017codingtestassignment.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.aptivist_u002.a10272017codingtestassignment.R;
import com.example.aptivist_u002.a10272017codingtestassignment.data.pojo.Item;
import com.example.aptivist_u002.a10272017codingtestassignment.data.pojo.ResultApi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = "MainActivityTAG_";
    private MainPresenter mainPresenter;

    private RecyclerView recyclerView;
    private MinimalAdapter minimalAdapter;
    private List<Item> resultList;

    private EditText textTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTag = findViewById(R.id.a_main_edit_tag);
        recyclerView = findViewById(R.id.a_main_recycler);

        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);

        resultList = new ArrayList<>();
        minimalAdapter = new MinimalAdapter(resultList);

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
    public void showResults(List<Item> results) {
        Log.d(TAG, "showResults: " + results);
        resultList.clear();
        resultList.addAll(results);
        minimalAdapter.notifyDataSetChanged();

    }

    public void loadData(View view) {
        mainPresenter.loadData(textTag.getText().toString());
    }
}
