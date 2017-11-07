package com.example.aptivist_u002.a10272017projectintegration.base;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void onAttachView(V view);

    void onDetachView();
}
