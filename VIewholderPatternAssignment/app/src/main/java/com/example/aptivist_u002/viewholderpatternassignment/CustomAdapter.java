package com.example.aptivist_u002.viewholderpatternassignment;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aptivist-U002 on 10/20/2017.
 */

class CustomAdapter extends ArrayAdapter<User> {

    public CustomAdapter(@NonNull Context context, @NonNull List<User> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row, null);
            viewHolder = new ViewHolder();
            viewHolder.firstName = convertView.findViewById(R.id.l_row_txt1);
            viewHolder.lastName = convertView.findViewById(R.id.l_row_txt2);
            viewHolder.image = convertView.findViewById(R.id.l_row_image);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User item = getItem(position);
        viewHolder.firstName.setText(item.getFirstname());
        viewHolder.lastName.setText(item.getLastName());
        //viewHolder.ima
        return convertView;
    }

    static class ViewHolder {
        private TextView firstName;
        private TextView lastName;
        private ImageView image;
    }

}


