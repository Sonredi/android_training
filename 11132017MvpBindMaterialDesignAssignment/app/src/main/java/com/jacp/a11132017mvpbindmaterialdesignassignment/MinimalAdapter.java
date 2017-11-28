package com.jacp.a11132017mvpbindmaterialdesignassignment;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jacp.a11132017mvpbindmaterialdesignassignment.databinding.CustomRowBinding;

import java.util.List;

/**
 * Created by Aptivist-U002 on 11/13/2017.
 */

public class MinimalAdapter extends RecyclerView.Adapter<MinimalAdapter.ViewHolder> {

    List<User> userList;

    public MinimalAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public MinimalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        //Binding
        CustomRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.custom_row, parent, false);
        //return new ViewHolder(view);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MinimalAdapter.ViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CustomRowBinding customRowBinding;

//        private TextView firstName;
//        private TextView lastName;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            firstName = itemView.findViewById(R.id.r_recycler_fName);
//            lastName = itemView.findViewById(R.id.r_recycler_lName);
//        }

        //Binding
        public ViewHolder(CustomRowBinding binding) {
            super(binding.getRoot());
            this.customRowBinding = binding;
        }

        public void bind(User user) {
//            firstName.setText(user.getFirstName());
//            lastName.setText(user.getLastName());

            //Binding
            customRowBinding.setUser(user);
            customRowBinding.executePendingBindings();
        }
    }
}
