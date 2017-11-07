package com.example.aptivist_u002.a10262017mvpassignment;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
