package com.example.aptivist_u002.a10252017unittestsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    @BindView(R.id.main_txt1)
    TextView textView;

    @BindView(R.id.main_edit1)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_btn1)

    public void doMagic() {
        int result = CalculatorHelper.addition(editText.getText().toString());
        textView.setText(String.valueOf(result));


    }


}
