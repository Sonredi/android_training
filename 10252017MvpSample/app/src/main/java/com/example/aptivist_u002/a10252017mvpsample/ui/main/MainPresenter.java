package com.example.aptivist_u002.a10252017mvpsample.ui.main;

import com.example.aptivist_u002.a10252017mvpsample.data.FakeRepository;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/25/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private FakeRepository fakeRepository;

    public MainPresenter(FakeRepository fakeRepository) {
        this.fakeRepository = fakeRepository;
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadData() {
        view.showProgress();
        try {
            List<String> results = fakeRepository.getFakeDataFromRestServer();
            view.showResults(results);
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideProgress();
        }
    }
}
