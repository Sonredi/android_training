package com.example.aptivist_u002.listeners;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivityTAG_";
    private Button button2;
    private Button button3;
    private Button button4;

    private EditText editText;

    CheckBox checkBox1;
    CheckBox checkBox2;
    LinearLayout linearLayout;

    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = (Button) findViewById(R.id.a_main_btn2);
        button3 = (Button) findViewById(R.id.a_main_btn3);
        button4 = (Button) findViewById(R.id.a_main_btn4);

        editText = (EditText) findViewById(R.id.a_main_et);

        checkBox1 = (CheckBox) findViewById(R.id.a_main_check1);
        checkBox2 = (CheckBox) findViewById(R.id.a_main_check2);

        linearLayout = (LinearLayout) findViewById(R.id.mainLayout);

        textView1 = (TextView) findViewById(R.id.a_main_tv1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomething(2);
            }
        });

        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "beforeTextChanged: " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "beforeTextChanged: " + s);
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    linearLayout.setBackgroundColor(Color.BLUE);
                } else {
                    linearLayout.setBackgroundColor(Color.RED);
                }

            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    textView1.setText("jose");
                } else {
                    textView1.setText(" ");
                }

            }
        });



    }

    public void doMagic(View view) {
        doSomething(1);
    }

    private void doSomething(int i) {
        Toast.makeText(this, i +"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        doSomething(3);
    }
}
