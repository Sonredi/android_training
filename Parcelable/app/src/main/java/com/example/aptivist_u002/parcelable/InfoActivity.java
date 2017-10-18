package com.example.aptivist_u002.parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tvName = (TextView) findViewById(R.id.tvName);
        tvGrade = (TextView) findViewById(R.id.tvGrade);
        Intent intent = getIntent();
        Student student = intent.getParcelableExtra("Object");
        tvName.setText(student.getName() + " " + student.getLastName());
        tvGrade.setText(String.valueOf(student.getGrade()));
    }
}
