package com.example.aptivist_u002.listviewfragmentsasigment;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListviewFragment.MethodsToImplement {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_frame, new ListviewFragment(), "LIST_FRAGMENT").commit();
    }


    public void showDataInFragmentDetail(String user) {
        Bundle bundle = new Bundle();
        DetailFragment detailFragment = new DetailFragment();
        bundle.putString("name", user);
        detailFragment.setArguments(bundle);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.login_frame, detailFragment, "DETAIL_FRAGMENT").addToBackStack(null).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.login_frame1, detailFragment, "DETAIL_FRAGMENT").commit();
        }
    }

    @Override
    public void showDetail(String user) {
        showDataInFragmentDetail(user);
    }
}
