package com.example.aptivist_u002.snackbarassignment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Aptivist-U002 on 10/20/2017.
 */

public class ViewHolder2 extends RecyclerView.ViewHolder {

    private ImageView ivExample;

    public ViewHolder2(View v) {
        super(v);
        ivExample = (ImageView) v.findViewById(R.id.r_row_image);
    }

    public ImageView getImageView() {
        return ivExample;
    }

    public void setImageView(ImageView ivExample) {
        this.ivExample = ivExample;
    }
}
