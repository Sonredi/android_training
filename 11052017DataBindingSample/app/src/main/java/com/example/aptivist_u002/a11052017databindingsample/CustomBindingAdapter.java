package com.example.aptivist_u002.a11052017databindingsample;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Aptivist-U002 on 11/5/2017.
 */

public class CustomBindingAdapter
{
    @BindingAdapter({"bind:profilePicture"})
    public static void loadImage(ImageView imageView, String url)
    {
        Picasso.with(imageView.getContext()).load(url).resize(200,200).into(imageView);
    }
}
