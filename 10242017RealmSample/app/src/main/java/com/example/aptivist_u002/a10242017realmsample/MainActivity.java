package com.example.aptivist_u002.a10242017realmsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    public void saveData(View view) {
        realm.beginTransaction();
        realm.copyToRealm(new User(1, new Date().toString(), 27));
        realm.commitTransaction();
    }

    public void loadData(View view) {
        List<User> users = realm.where(User.class).findAll();
        for (User user : users) {
            Log.d(TAG, "loadData: " + user.getId() + " " + user.getName() + " " + user.getAge());
        }
    }
}
