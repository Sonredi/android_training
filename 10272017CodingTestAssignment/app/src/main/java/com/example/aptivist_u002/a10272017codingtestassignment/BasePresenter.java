package com.example.aptivist_u002.a10272017codingtestassignment;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void dettachView();
}
