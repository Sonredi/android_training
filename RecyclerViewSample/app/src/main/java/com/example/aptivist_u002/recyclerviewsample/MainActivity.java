package com.example.aptivist_u002.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<User> users;

    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        users = createUSers();

        customAdapter = new CustomAdapter(users);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
    }

    private List<User> createUSers() {
        return Arrays.asList(
                new User("Edwin", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Omar", "Ham", "https://cdn1.iconfinder.com/data/icons/unique-round-blue/93/user-512.png")
        );
    }
}
