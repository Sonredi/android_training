package com.example.aptivist_u002.a10272017projectintegration.ui.main;

import com.example.aptivist_u002.a10272017projectintegration.base.BasePresenter;
import com.example.aptivist_u002.a10272017projectintegration.base.BaseView;
import com.example.aptivist_u002.a10272017projectintegration.data.pojo.Feature;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public interface MainContract {

    interface View extends BaseView {
        void showResults(List<Feature> results);

        void showProgress();

        void hideProgress();
    }

    interface Presenter extends BasePresenter<View> {
        void loadEarthquakes();
    }

}
