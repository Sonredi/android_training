package com.example.aptivist_u002.a10262017mvpassignment.ui.calculator;

import com.example.aptivist_u002.a10262017mvpassignment.data.helper.CalculatorHelper;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public class CalculatorPresenter implements CalculatorContract.Presenter {

    private CalculatorContract.View view;
    private CalculatorHelper calculatorHelper;

    public CalculatorPresenter(CalculatorHelper calculatorHelper) {
        this.calculatorHelper = calculatorHelper;
    }

    @Override
    public void attachView(CalculatorContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void loadSubtractData(String input) {
        view.showProgress();
        try {
            view.showSubtractResult(calculatorHelper.subtraction(input));
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideProgress();
        }
    }

    @Override
    public void loadMultiplyData(String input) {
        view.showProgress();
        try {
            view.showMultiplyResult(calculatorHelper.multiplication(input));
        } catch (Exception e) {
            view.showError(e.getMessage());
        } finally {
            view.hideProgress();
        }
    }
}
