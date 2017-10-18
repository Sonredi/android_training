package com.example.aptivist_u002.parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView etFirstName;
    private TextView etLastName;
    private TextView etGrade;
    private Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (TextView) findViewById(R.id.etFirstName);
        etLastName = (TextView) findViewById(R.id.etLastName);
        etGrade = (TextView) findViewById(R.id.etGrade);


    }

    public void send(View view) {
        Student student = new Student(etFirstName.getText().toString(), etLastName.getText().toString(), Integer.parseInt(etGrade.getText().toString()));
        Toast.makeText(this, etFirstName.getText() + " " + etLastName.getText(), Toast.LENGTH_LONG ).show();

        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("Object", student);
        startActivity(intent);
    }
}
