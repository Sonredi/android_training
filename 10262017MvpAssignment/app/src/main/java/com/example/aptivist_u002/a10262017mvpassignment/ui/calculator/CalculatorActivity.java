package com.example.aptivist_u002.a10262017mvpassignment.ui.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aptivist_u002.a10262017mvpassignment.R;
import com.example.aptivist_u002.a10262017mvpassignment.data.helper.CalculatorHelper;

public class CalculatorActivity extends AppCompatActivity implements CalculatorContract.View {

    private static final String TAG = "CalculatorActivityTAG_";
    private CalculatorPresenter calculatorPresenter;
    private EditText editText1;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editText1 = findViewById(R.id.a_calculator_edit1);
        textView1 = findViewById(R.id.a_calculator_txt1);
        calculatorPresenter = new CalculatorPresenter(new CalculatorHelper());
        calculatorPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        calculatorPresenter.detachView();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showSubtractResult(int output) {
        Log.d(TAG, "showSubtractResult: " + output);
        textView1.setText(String.valueOf(output));
    }

    @Override
    public void showMultiplyResult(Double output) {
        Log.d(TAG, "showMultiplyResult: " + output);
        textView1.setText(String.valueOf(output));
    }

    public void subtractData(View view) {
        calculatorPresenter.loadSubtractData(editText1.getText().toString());
    }

    public void multiplyData(View view) {
        calculatorPresenter.loadMultiplyData(editText1.getText().toString());
    }
}
