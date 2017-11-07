package com.example.aptivist_u002.recyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/19/2017.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    List<User> users;

    public CustomAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView textView;
        final ImageView imageView;
        final Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.r_row_txt);
            imageView = itemView.findViewById(R.id.r_row_image);
            button = itemView.findViewById(R.id.r_row_btn1);
        }

        public void bind(User user) {
            textView.setText(user.getFirstName());
            final String last = user.getLastName();
            Picasso.with(itemView.getContext()).load(user.getImage()).into(imageView);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), last+"", Toast.LENGTH_SHORT).show();
                }
            });



        }
    }
}
