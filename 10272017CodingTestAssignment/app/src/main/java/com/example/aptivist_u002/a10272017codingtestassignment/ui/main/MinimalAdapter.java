package com.example.aptivist_u002.a10272017codingtestassignment.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aptivist_u002.a10272017codingtestassignment.data.pojo.Item;
import com.example.aptivist_u002.a10272017codingtestassignment.R;
import java.util.List;

/**
 * Created by Aptivist-U002 on 10/27/2017.
 */

public class MinimalAdapter extends RecyclerView.Adapter<MinimalAdapter.ViewHolder> {

    private List<Item> results;

    public MinimalAdapter(List<Item> results) {
        this.results = results;
    }

    public interface OnItemCLickLIstener {
        void onItemClick();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.unit_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results != null ? results.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.r_title);
        }

        public void bind(Item s) {
            textView.setText(s.getTitle());
        }
    }
}
