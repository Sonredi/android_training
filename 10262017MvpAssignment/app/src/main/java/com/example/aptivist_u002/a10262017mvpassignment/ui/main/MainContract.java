package com.example.aptivist_u002.a10262017mvpassignment.ui.main;

import com.example.aptivist_u002.a10262017mvpassignment.BasePresenter;
import com.example.aptivist_u002.a10262017mvpassignment.BaseView;
import com.example.aptivist_u002.a10262017mvpassignment.data.pojo.ResultApi;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public interface MainContract {


    interface View extends BaseView {
        void showResults(List<ResultApi> result);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData(String user);
    }

}
