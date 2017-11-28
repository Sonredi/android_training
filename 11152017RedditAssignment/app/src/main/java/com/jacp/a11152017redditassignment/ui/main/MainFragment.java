package com.jacp.a11152017redditassignment.ui.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacp.a11152017redditassignment.App;
import com.jacp.a11152017redditassignment.R;
import com.jacp.a11152017redditassignment.data.model.Post;
import com.jacp.a11152017redditassignment.di.ApplicationComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainContract.View {

    private static final String TAG = "MainFragmentTAg_";
    @Inject
    MainPresenter mainPresenter;
    private RecyclerView recyclerView;
    private MinimalAdapter minimalAdapter;
    private List<Post> postList;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        injectDependencies();
        mainPresenter.attachView(this);

        postList = new ArrayList<>();
        minimalAdapter = new MinimalAdapter(postList);

        recyclerView = view.findViewById(R.id.f_main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(minimalAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mainPresenter.detachView();
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.loadRedditPosts();

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void injectDependencies() {
        ApplicationComponent applicationComponent =
                ((App) getActivity().getApplication()).getApplicationComponent();
        DaggerMainComponent.builder()
                .applicationComponent(applicationComponent)
                .mainModule(new MainModule())
                .build()
                .Inject(this);
    }

    @Override
    public void showAllPosts(List<Post> postList) {
        Log.d(TAG, "showAllPosts: " + postList.get(0).getTitle());
        this.postList.clear();
        this.postList.addAll(postList);
        minimalAdapter.notifyDataSetChanged();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
