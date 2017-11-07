package com.example.aptivist_u002.a10252017mvpsample.ui.main;

import com.example.aptivist_u002.a10252017mvpsample.data.FakeRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class mainPresenterMockedTest {

    @Mock
    FakeRepository fakeRepository;
    @Mock
    MainContract.View view;

    private MainPresenter mainPresenter;
    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter(fakeRepository);
    }

    @Test
    public void whenInstancePresenter_shouldNotBeNull() throws Exception {
        assertNotNull(mainPresenter);
    }

    @Test
    public void whenPresenterLoadsData_viewShouldProgress() throws Exception {
        List<String> fakeList1 = Arrays.asList("jose", "cruz");
        List<String> fakeList = Arrays.asList("helo", "world");
        when(fakeRepository.getFakeDataFromRestServer()).thenReturn(fakeList);
        mainPresenter.attachView(view);
        mainPresenter.loadData();

        verify(view).showProgress();
        verify(view).showResults(fakeList);
        verify(view).hideProgress();

    }

    @Test
    public void whenPresenterLoadsDataCatchesException_viewShouldShowError() throws Exception {
        when(fakeRepository.getFakeDataFromRestServer()).thenThrow(new RuntimeException("hello"));

        mainPresenter.attachView(view);
        mainPresenter.loadData();

        verify(view).showProgress();
        verify(view).showError("hello");
        verify(view).hideProgress();
    }
}
