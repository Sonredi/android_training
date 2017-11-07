package com.example.aptivist_u002.snackbarassignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/20/2017.
 */

class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Object> users;
    private final OnItemClickListener onItemClickListener;
    private final int USER = 0, IMAGE = 1;


    public CustomAdapter(List<Object> users, OnItemClickListener onItemClickListener) {
        this.users = users;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(User item);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case USER:
                View v1 = inflater.inflate(R.layout.item_row, viewGroup, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case IMAGE:
                View v2 = inflater.inflate(R.layout.image_row, viewGroup, false);
                viewHolder = new ViewHolder2(v2);
                break;
            default:
                View v3 = inflater.inflate(R.layout.item_row, viewGroup, false);
                viewHolder = new ViewHolder1(v3);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case USER:
                ViewHolder1 vh1 = (ViewHolder1) viewHolder;
                configureViewHolder1(vh1, position, onItemClickListener);
                break;
            case IMAGE:
                ViewHolder2 vh2 = (ViewHolder2) viewHolder;
                configureViewHolder2(vh2);
                break;
            default:
                ViewHolder1 vh3 = (ViewHolder1) viewHolder;
                configureViewHolder1(vh3, position, onItemClickListener);
                break;
        }

    }

    private void configureViewHolder1(ViewHolder1 vh1, int position, final OnItemClickListener onItemClickListener) {
        final User user = (User) users.get(position);
        if (user != null) {
            vh1.getLabel1().setText("First name: " + user.getFirstName());
            vh1.getLabel2().setText("Lastname: " + user.getLastName());
            vh1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(user);
                }
            });

        }
    }

    private void configureViewHolder2(ViewHolder2 vh2) {
        vh2.getImageView().setImageResource(R.drawable.ic_assignment_turned_in_black_24dp);
    }

    @Override
    public int getItemViewType(int position) {
        if (users.get(position) instanceof User) {
            return USER;
        } else if (users.get(position) instanceof String) {
            return IMAGE;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView textView1;
        final TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.r_row_txt1);
            textView2 = itemView.findViewById(R.id.r_row_txt2);
        }

        public void bind(final User user, final OnItemClickListener onItemClickListener) {
            textView1.setText(user.getFirstName());
            textView2.setText(user.getLastName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(user);
                }
            });
        }
    }
}
