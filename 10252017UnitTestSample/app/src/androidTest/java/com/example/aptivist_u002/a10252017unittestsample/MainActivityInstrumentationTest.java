package com.example.aptivist_u002.a10252017unittestsample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Aptivist-U002 on 10/25/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void whenSimpleNumber_shouldCalculateSum() throws Exception {
        onView(withId(R.id.main_edit1)).perform(typeText("1+1"));
        onView(withId(R.id.main_btn1)).perform(click());
        onView(withId(R.id.main_txt1)).check(matches(withText("2")));
    }
}
