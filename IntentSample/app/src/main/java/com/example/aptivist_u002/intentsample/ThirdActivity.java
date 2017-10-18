package com.example.aptivist_u002.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void oneMagic(View view) {
        sendResultBack(1);
    }

    public void twoMagic(View view) {
        sendResultBack(2);
    }

    public void threeMagic(View view) {
        sendResultBack(3);
    }

    private void sendResultBack(int result) {
        Intent intent = new Intent();
        intent.putExtra("MY_KEY", result);
        setResult(RESULT_OK, intent);
        finish();
    }
}
