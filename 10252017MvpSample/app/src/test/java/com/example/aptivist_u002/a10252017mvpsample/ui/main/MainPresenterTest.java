package com.example.aptivist_u002.a10252017mvpsample.ui.main;

import com.example.aptivist_u002.a10252017mvpsample.data.FakeRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Aptivist-U002 on 10/25/2017.
 */
public class MainPresenterTest {
    private FakeRepository fakeRepository;
    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        fakeRepository = new FakeRepository();
        mainPresenter = new MainPresenter(new FakeRepository());
    }

    @After
    public void tearDown() throws Exception {
        fakeRepository = null;
        mainPresenter = null;
    }

    @Test
    public void mainPresenterNotNull() throws Exception {
        assertNotNull(mainPresenter);
    }

    @Test
    public void whenDataRequested_viewShouldUpdate() throws Exception {
        mainPresenter.attachView(new MainContract.View() {
            @Override
            public void showResults(List<String> results) {
                assertEquals(4, results.size());
            }

            @Override
            public void showError(String error) {

            }

            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }
        });

        mainPresenter.loadData();
    }
}