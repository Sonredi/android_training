package com.example.aptivist_u002.a10282017projectintegrationassignment.ui.main;

import com.example.aptivist_u002.a10282017projectintegrationassignment.base.BasePresenter;
import com.example.aptivist_u002.a10282017projectintegrationassignment.base.BaseView;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.pojo.Item;
import com.example.aptivist_u002.a10282017projectintegrationassignment.data.pojo.ResultApi;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */

public interface MainContract {

    interface View extends BaseView {
        void showResults(List<Item> results);

        void showProgress();

        void hideProgress();
    }

    interface Presenter extends BasePresenter<View> {
        void loadFlickrInfo();
    }
}