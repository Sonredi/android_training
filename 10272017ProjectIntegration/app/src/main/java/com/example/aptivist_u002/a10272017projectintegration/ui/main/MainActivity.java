package com.example.aptivist_u002.a10272017projectintegration.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.util.Log;
import android.widget.Toast;

import com.example.aptivist_u002.a10272017projectintegration.App;
import com.example.aptivist_u002.a10272017projectintegration.R;
import com.example.aptivist_u002.a10272017projectintegration.data.pojo.Feature;
import com.example.aptivist_u002.a10272017projectintegration.di.ApplicationComponent;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private static final String TAG = "MainActivityTAG_";
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectDependencies();
        mainPresenter.onAttachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.loadEarthquakes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDetachView();
    }

    @Override
    public void ShowError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "ShowError: " + error);
    }

    @Override
    public void injectDependencies() {
        ApplicationComponent applicationComponent = ((App) getApplication()).getApplicationComponent();
        DaggerMainComponent.builder()
                .applicationComponent(applicationComponent)
                .mainModule(new MainModule())
                .build()
                .Inject(this);
    }

    @Override
    public void showResults(List<Feature> results) {
        for (Feature result : results) {
            Log.d(TAG, "showResults: " + result);
        }
    }

    @Override
    public void showProgress() {
        // TODO: 10/27/2017
    }

    @Override
    public void hideProgress() {
        // TODO: 10/27/2017
    }
}
