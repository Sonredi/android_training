package com.example.aptivist_u002.a10252017mvpsample;

/**
 * Created by Aptivist-U002 on 10/25/2017.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
