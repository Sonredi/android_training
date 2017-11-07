package com.example.aptivist_u002.a10282017projectintegrationassignment.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.util.Log;
import android.widget.Toast;

import com.example.aptivist_u002.a10282017projectintegrationassignment.App;
import com.example.aptivist_u002.a10282017projectintegrationassignment.R;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.pojo.Item;
import com.example.aptivist_u002.a10282017projectintegrationassignment.di.ApplicationComponent;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = "MainActivityTAG_";
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectDependencies();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.loadFlickrInfo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void injectDependencies() {
        ApplicationComponent applicationComponent =
                ((App) getApplication()).getApplicationComponent();
        DaggerMainComponent.builder()
                .applicationComponent(applicationComponent)
                .mainModule(new MainModule())
                .build()
                .Inject(this);
    }

    @Override
    public void showResults(List<Item> results) {
        for (Item result : results) {
            Log.d(TAG, "showResults: " + result.getTitle());
        }

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
