package com.example.aptivist_u002.a11022017robolectricsample;

/**
 * Created by Aptivist-U002 on 11/2/2017.
 */

public interface MainContract {
    interface View {
        void showError(String error);

        void incrementCounter(int counter);

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void doCalculation();

        void init(View view);

        void destroy();

    }

}
