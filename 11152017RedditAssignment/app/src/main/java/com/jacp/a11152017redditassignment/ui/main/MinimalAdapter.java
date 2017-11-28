package com.jacp.a11152017redditassignment.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jacp.a11152017redditassignment.R;
import com.jacp.a11152017redditassignment.data.model.Post;

import java.util.List;

/**
 * Created by Aptivist-U002 on 11/19/2017.
 */

public class MinimalAdapter extends RecyclerView.Adapter<MinimalAdapter.ViewHolder> {

    private List<Post> postList;

    public MinimalAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public MinimalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.main_row_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MinimalAdapter.ViewHolder holder, int position) {
        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList != null ? postList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView textAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.r_text_title);
            textAuthor = itemView.findViewById(R.id.r_text_author);
        }

        public void bind(Post post) {
            textTitle.setText(post.getTitle());
            textAuthor.setText(post.getAuthor());
        }
    }
}
