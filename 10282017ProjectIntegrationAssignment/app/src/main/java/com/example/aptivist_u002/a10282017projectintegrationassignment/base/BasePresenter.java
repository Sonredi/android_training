package com.example.aptivist_u002.a10282017projectintegrationassignment.base;

/**
 * Created by Aptivist-U002 on 10/28/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
