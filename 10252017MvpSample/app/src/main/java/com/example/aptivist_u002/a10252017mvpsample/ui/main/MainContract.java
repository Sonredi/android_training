package com.example.aptivist_u002.a10252017mvpsample.ui.main;

import com.example.aptivist_u002.a10252017mvpsample.BasePresenter;
import com.example.aptivist_u002.a10252017mvpsample.BaseView;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/25/2017.
 */

public interface MainContract {

    interface View extends BaseView {
        void showResults(List<String> results);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData();
    }

}
