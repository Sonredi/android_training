package com.jacp.a11152017redditassignment.base;

/**
 * Created by Aptivist-U002 on 11/15/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
