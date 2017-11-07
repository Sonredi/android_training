package com.example.aptivist_u002.a11022017robolectricsample;

import com.example.aptivist_u002.a11022017robolectricsample.data.MathModel;

/**
 * Created by Aptivist-U002 on 11/2/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    public MainContract.View view;
    private MathModel mathModel;

    public MainPresenter(MathModel mathModel) {
        this.mathModel = mathModel;
    }

    @Override
    public void doCalculation() {
        int result = mathModel.calculate();
        view.incrementCounter(result);
    }

    @Override
    public void init(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        this.view = null;

    }
}
