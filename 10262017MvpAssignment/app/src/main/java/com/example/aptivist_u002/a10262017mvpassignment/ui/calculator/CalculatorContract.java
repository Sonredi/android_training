package com.example.aptivist_u002.a10262017mvpassignment.ui.calculator;

import com.example.aptivist_u002.a10262017mvpassignment.BasePresenter;
import com.example.aptivist_u002.a10262017mvpassignment.BaseView;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public interface CalculatorContract {

    interface View extends BaseView {
        void showSubtractResult(int output);

        void showMultiplyResult(Double output);
    }

    interface Presenter extends BasePresenter<View> {
        void loadSubtractData(String input);

        void loadMultiplyData(String input);
    }

}
