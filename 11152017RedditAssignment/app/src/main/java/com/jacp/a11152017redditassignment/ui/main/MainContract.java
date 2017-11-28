package com.jacp.a11152017redditassignment.ui.main;

import com.jacp.a11152017redditassignment.base.BasePresenter;
import com.jacp.a11152017redditassignment.base.BaseView;
import com.jacp.a11152017redditassignment.data.model.Post;

import java.util.List;

/**
 * Created by Aptivist-U002 on 11/16/2017.
 */

public interface MainContract {

    interface View extends BaseView {
        void showAllPosts(List<Post> postList);

        void showProgress();

        void hideProgress();
    }

    interface Presenter extends BasePresenter<View> {
        void loadRedditPosts();
    }
}
