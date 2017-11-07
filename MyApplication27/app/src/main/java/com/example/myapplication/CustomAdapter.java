package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 10/19/17.
 */

public class CustomAdapter extends ArrayAdapter<User> {

    CustomAdapter(@NonNull Context context, @NonNull List<User> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        final View view = layoutInflater.inflate(R.layout.list_row, parent, false);

        final TextView textView = view.findViewById(R.id.l_row_txt);
        final ImageView imageView = view.findViewById(R.id.l_row_image);
        final Button button = view.findViewById(R.id.l_row_btn);

        final User item = getItem(position);

        textView.setText(item.getFirstname());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), ""+item.getLastName(), Toast.LENGTH_SHORT).show();
            }
        });

        Picasso.with(getContext()).load(item.getImage()).into(imageView);
        return view;
    }
}
