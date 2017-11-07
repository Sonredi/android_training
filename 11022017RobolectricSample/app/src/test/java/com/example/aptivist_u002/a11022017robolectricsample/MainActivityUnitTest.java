package com.example.aptivist_u002.a11022017robolectricsample;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Aptivist-U002 on 11/2/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityUnitTest {

//    @Test
//    public void whenClickButton_textViewChangeValue() throws Exception {
//        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
//
//        Button button = mainActivity.findViewById(R.id.a_main_btn);
//        TextView textView = mainActivity.findViewById(R.id.a_main_txt);
//
//        button.performClick();
//        assertThat(textView.getText(), equalTo("One Two Three"));
//        assertEquals("One Two Three", textView.getText());
//        assertEquals("new toast", ShadowToast.getTextOfLatestToast());
//    }

    private MainActivity mainActivity;
    private TextView textView;
    private Button button;
    private ProgressBar progressBar;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        textView = mainActivity.findViewById(R.id.a_main_txt);
        button = mainActivity.findViewById(R.id.a_main_btn);
        progressBar = mainActivity.findViewById(R.id.a_main_progress);
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
        textView = null;
        button = null;
        progressBar = null;
    }

    @Test
    public void showProgress_progressBarVisible() throws Exception {
        //Setup stage
        progressBar.setVisibility(View.GONE);
        //Action stage
        mainActivity.showProgress();
        //Result stage
        assertEquals(View.VISIBLE, progressBar.getVisibility());
    }

    @Test
    public void incrementCounter_textViewUpdated() throws Exception {
        //Setup stage
        textView.setText("");
        int counter = 5;
        //Action stage
        mainActivity.incrementCounter(counter);
        //Results stage
        String actualString = textView.getText().toString();
        int actualInt = Integer.parseInt(actualString);
        assertEquals(counter, actualInt);
    }

    @Test
    public void hideProgress_progressBarInvisiblre() throws Exception {
        //Setup stage
        progressBar.setVisibility(View.VISIBLE);
        //Action stage
        mainActivity.hideProgress();
        //Result stage
        assertEquals(View.INVISIBLE, progressBar.getVisibility());
    }

    @Test
    public void showError_toastShouldPopUp() throws Exception {
        String error = "Could not be found";
        mainActivity.showError(error);
        assertEquals(error, ShadowToast.getTextOfLatestToast());
    }
}
