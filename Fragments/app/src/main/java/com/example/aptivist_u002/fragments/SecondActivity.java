package com.example.aptivist_u002.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addPink(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        int id = view.getId();
        if (id == R.id.a_main_btn1) {
            fragmentTransaction.add(R.id.a_second_frame, new PinkFragment(), "PINK_FRAGMENT");
        } else if (id == R.id.a_main_btn4) {
            fragmentTransaction.add(R.id.a_second_frame2, new PinkFragment(), "PINK_FRAGMENT");
        }


        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void addBlue(View view) {
        int id = view.getId();
        int idFragment=0;
        if (id == R.id.a_main_btn2){
            idFragment = R.id.a_second_frame;
        } else if (id == R.id.a_main_btn5) {
            idFragment = R.id.a_second_frame2;
        }
        getSupportFragmentManager().beginTransaction()
                .add(idFragment, new BlueFragment(), "PINK_FRAGMENT").addToBackStack(null).commit();
    }

    public void addBlack(View view) {
        int id = view.getId();
        int idFragment=0;
        if (id == R.id.a_main_btn3){
            idFragment = R.id.a_second_frame;
        } else if (id == R.id.a_main_btn6) {
            idFragment = R.id.a_second_frame2;
        }
        getSupportFragmentManager().beginTransaction()
                .add(idFragment, new RedFragment(), "RED_FRAGMENT").addToBackStack(null).commit();
    }

}
