package com.example.aptivist_u002.glidelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MainActivity extends AppCompatActivity {


    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int radius = 30; // corner radius, higher value = more rounded
        int margin = 10; // crop margin, set to 0 for corners with no crop
        image1 = (ImageView) findViewById(R.id.main_image1);
        Glide.with(this)
                .load("http://via.placeholder.com/200.png")
                .bitmapTransform(new RoundedCornersTransformation(this, radius, margin))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        // log exception
                        //Log.e("TAG", "Error loading image", e);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(image1);

        image2 = (ImageView) findViewById(R.id.main_image2);
        Glide.with(this)
                .load("http://via.placeholder.com/200.png")
                .override(200, 100)
                .into(image2);

        image3 = (ImageView) findViewById(R.id.main_image3);
        Glide.with(this)
                .load("http://via.placeholder.com/qw.png")
                .placeholder(R.drawable.ic_autorenew_black_24dp)
                .error(R.drawable.ic_not_interested_black_24dp)
                .into(image3);

        image4 = (ImageView) findViewById(R.id.main_image4);
        Glide.with(this)
                .load("http://via.placeholder.com/300.png")
                .override(200, 500)
                .centerCrop()
                .into(image4);

        image5 = (ImageView) findViewById(R.id.main_image5);
        Glide.with(this)
                .load("http://via.placeholder.com/300.png")
                .override(100, 200) // resizes the image to 100x200 pixels but does not respect aspect ratio
                .into(image5);
    }
}
