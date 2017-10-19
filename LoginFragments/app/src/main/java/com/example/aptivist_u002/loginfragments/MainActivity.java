package com.example.aptivist_u002.loginfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginFragment.MethodsToImplement {

    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.login_frame, new LoginFragment(), "LOGIN_FRAGMENT").commit();
    }

    public void authenticate(String user, String password) {

        String hardCodeName = "jose";
        String hardCodePass = "abcd";
        if (hardCodeName.equals(user) && hardCodePass.equals(password)) {

            Bundle bundle = new Bundle();
            DetailFragment detailFragment = new DetailFragment();
            bundle.putString("name", user);
            bundle.putString("age", "27");
            detailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.login_frame, detailFragment, "DETAIL_FRAGMENT").addToBackStack(null).commit();

        } else {
            Toast.makeText(this, "not a valid user", Toast.LENGTH_SHORT).show();
        }
        Log.d(TAG, "authenticate: " + user + " " + password);

    }

    @Override
    public void checkData(String user, String password) {
        authenticate(user, password);
    }
}
