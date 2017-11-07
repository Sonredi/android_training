package com.example.aptivist_u002.a10292017compoundviewsample;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Aptivist-U002 on 10/29/2017.
 */

public class MyCompoundView extends LinearLayout {
    private ImageView imageView;
    private TextView textView;

    private static final String DEFAULT_IMAGE = "http://i.imgur.com/DvpvklR.png";
    private static final String DEFAUlT_TEXT = "JACP";

    private String imgLoader;
    private String txtLoader;

    LinearLayout.LayoutParams layoutParams;

    public MyCompoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        imageView = new ImageView(context);
        textView = new TextView(context);

        imageView.setMaxHeight(200);
        imageView.setMaxWidth(200);
        addView(imageView);
        addView(textView);

        imgLoader = (imgLoader == null) ? DEFAULT_IMAGE : imgLoader;
        txtLoader = (txtLoader == null) ? DEFAUlT_TEXT : txtLoader;

        Picasso.with(getContext()).load(imgLoader).into(imageView);
        textView.setText(txtLoader);

        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (10*scale + 0.5f);
        int dpAsPixelsM = (int) (500*scale + 0.5f);
        setPadding(dpAsPixels,dpAsPixels,dpAsPixels,dpAsPixels);



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixelsM = (int) (50*scale + 0.5f);
        layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        layoutParams.setMargins(dpAsPixelsM, dpAsPixelsM, dpAsPixelsM, dpAsPixelsM);
        setLayoutParams(layoutParams);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setImage(String url) {
        imgLoader = url;
        Picasso.with(getContext()).load(imgLoader).into(imageView);

    }
}
