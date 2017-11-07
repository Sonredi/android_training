package com.example.aptivist_u002.a11022017robolectricsample;

import com.example.aptivist_u002.a11022017robolectricsample.data.MathModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Aptivist-U002 on 11/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterUnitTest {

    @Mock
    MathModel mathModel;
    @Mock
    MainContract.View view;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter(mathModel);
    }

    @After
    public void tearDown() throws Exception {
        mainPresenter = null;
    }

    @Test
    public void init_viewNotNull() throws Exception {
        mainPresenter.view = null;
        mainPresenter.init(view);

        assertNotNull(mainPresenter.view);
    }

    @Test
    public void destroy_viewShouldBeNull() throws Exception {
        mainPresenter.view = this.view;

        mainPresenter.destroy();

        assertNull(mainPresenter.view);
    }

    @Test
    public void doCalculation_shouldUpdateView() throws Exception {
        when(mathModel.calculate()).thenReturn(10);
        mainPresenter.init(view);
        mainPresenter.doCalculation();
        verify(view).incrementCounter(10);
    }
}
