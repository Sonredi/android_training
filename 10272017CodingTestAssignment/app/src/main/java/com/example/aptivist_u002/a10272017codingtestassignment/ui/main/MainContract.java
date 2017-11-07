package com.example.aptivist_u002.a10272017codingtestassignment.ui.main;

import com.example.aptivist_u002.a10272017codingtestassignment.BasePresenter;
import com.example.aptivist_u002.a10272017codingtestassignment.BaseView;
import com.example.aptivist_u002.a10272017codingtestassignment.data.pojo.Item;
import com.example.aptivist_u002.a10272017codingtestassignment.data.pojo.ResultApi;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public interface MainContract {

    interface View extends BaseView {
        void showResults(List<Item> results);
    }

    interface Presenter extends BasePresenter<View> {

        void loadData(String input);
    }
}
