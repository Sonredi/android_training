package com.example.aptivist_u002.asynctaskmethods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.main_progress);

    }

    public void startMagic(View view) {
        new MyTask(progressBar).execute();
    }

    public void showMagic(View view) {
        Toast.makeText(this, "My toast", Toast.LENGTH_SHORT).show();
    }
}
