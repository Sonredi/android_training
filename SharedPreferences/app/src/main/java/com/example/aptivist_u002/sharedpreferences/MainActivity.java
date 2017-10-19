package com.example.aptivist_u002.sharedpreferences;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String MY_SHARED_KEY = "MY_KEY";
    private static final String TAG = "MainActivityTAG_";

    private ListView listView;
    private ArrayList<String> users;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_list1);
        users = new ArrayList<>();
        users.add("Edwin");
        users.add("Omar");
        users.add("Pepe");




        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, users){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String id = sharedPreferences.getString("CURRENT_ID", "-1");
                Log.d(TAG, "getView--: " + id);
                if (position == Integer.parseInt(id)) {
                    Log.d(TAG, "getView: " + position);
                    String colorId = sharedPreferences.getString("CURRENT_COLOR", "-1");
                    view.setBackgroundColor(Integer.parseInt(colorId));
                } else {view.setBackgroundColor(1);}
                return view;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("CURRENT_COLOR", String.valueOf(Color.BLUE));


                String idBefore = sharedPreferences.getString("CURRENT_ID", "-1");
                if (Integer.parseInt(idBefore) != -1){
                    parent.getChildAt(Integer.parseInt(idBefore)).setBackgroundColor(1);
                }
                editor.putString("CURRENT_ID", String.valueOf(position));
                parent.getChildAt(position).setBackgroundColor(Color.BLUE);
                editor.commit();
            }
        });
    }

    public void doMagic(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MY_SHARED_KEY, new Date().toString());
        editor.commit();
    }

    public void loadMagic(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedDate = sharedPreferences.getString(MY_SHARED_KEY, null);
        Log.d(TAG, "loadMagic: " + savedDate);
    }
}
