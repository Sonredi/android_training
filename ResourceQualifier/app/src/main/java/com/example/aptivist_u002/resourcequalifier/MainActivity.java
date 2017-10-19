package com.example.aptivist_u002.resourcequalifier;

import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private ListView listView;
    private ArrayList<String> users;
    private ArrayAdapter<String> adapter;
    private EditText editText;

    private ImageView imageVIew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new ArrayList<>();
        users.add("Edwin");
        users.add("Omar");
        users.add("Pepe");

        imageVIew = (ImageView) findViewById(R.id.main_image);

        textView1 = (TextView) findViewById(R.id.main_textView1);
        listView = (ListView) findViewById(R.id.a_main_list1);
        editText = (EditText) findViewById(R.id.main_editText1);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String userClicked = users.get(position);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", userClicked);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, userClicked, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addMagic(View view) {
        users.add(editText.getText().toString());
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("MY_KEY", users);
        outState.putString("E_TEXT", textView1.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> restoredUsers = savedInstanceState.getStringArrayList("MY_KEY");
        if (!restoredUsers.isEmpty()) {
            users.clear();
            users.addAll(restoredUsers);
            adapter.notifyDataSetChanged();
        }
        String textRestored = savedInstanceState.getString("E_TEXT");
        if (!textRestored.isEmpty() && textRestored!=null){
            textView1.setText(textRestored);
        }
    }

    public void seteaText(View view) {

        textView1.setText(editText.getText().toString());
    }

    public void loadImage(View view) {
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageVIew);
    }
}
