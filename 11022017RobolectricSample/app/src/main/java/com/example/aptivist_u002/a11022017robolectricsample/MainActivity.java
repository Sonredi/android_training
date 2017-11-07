package com.example.aptivist_u002.a11022017robolectricsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aptivist_u002.a11022017robolectricsample.data.MathModel;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private Button button;
    private TextView textView;
    private ProgressBar progressBar;
    private MainPresenter mainPresenter;
    private MathModel mathModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.a_main_btn);
        textView = findViewById(R.id.a_main_txt);
        progressBar = findViewById(R.id.a_main_progress);

        mathModel = new MathModel();
        mainPresenter = new MainPresenter(mathModel);

        button.setOnClickListener(v -> textView.setText("One Two Three"));
//        button.setOnClickListener(v -> Toast.makeText(this, "new toast", Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.init(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.destroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(v -> mainPresenter.doCalculation());
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void incrementCounter(int counter) {
        textView.setText(String.valueOf(counter));
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
