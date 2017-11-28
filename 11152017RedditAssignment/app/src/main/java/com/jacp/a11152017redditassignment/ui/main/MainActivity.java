package com.jacp.a11152017redditassignment.ui.main;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jacp.a11152017redditassignment.App;
import com.jacp.a11152017redditassignment.R;
import com.jacp.a11152017redditassignment.data.model.Post;
import com.jacp.a11152017redditassignment.di.ApplicationComponent;
import com.jacp.a11152017redditassignment.ui.createPost.AddPostActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAg_";

    private FloatingActionButton floatingActionButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.a_main_frame, new MainFragment(), "DASH")
                .commit();

        floatingActionButton = findViewById(R.id.floating_button);
        floatingActionButton.setOnClickListener(v -> triggerAddPostActivity());

    }

    private void triggerAddPostActivity() {
        Intent intent = new Intent(this, AddPostActivity.class);
        startActivity(intent);
    }
}
