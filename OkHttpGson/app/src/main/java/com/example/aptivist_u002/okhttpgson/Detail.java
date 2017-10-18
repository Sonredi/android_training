package com.example.aptivist_u002.okhttpgson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    private TextView tvName;
    private TextView tvAge;
    private TextView tvGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvGrade = (TextView) findViewById(R.id.tvGrade);

        Intent intent = getIntent();
        Student student = intent.getParcelableExtra("Object");
        tvName.setText("Name: " + student.getNombre());
        tvAge.setText("Age: " + student.getAge());
        tvGrade.setText("Grade: " + student.getGrade());

    }
}
