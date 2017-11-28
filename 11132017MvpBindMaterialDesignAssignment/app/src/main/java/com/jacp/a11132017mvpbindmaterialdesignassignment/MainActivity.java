package com.jacp.a11132017mvpbindmaterialdesignassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MinimalAdapter minimalAdapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = createUsers();
        minimalAdapter = new MinimalAdapter(userList);

        recyclerView = findViewById(R.id.a_main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(minimalAdapter);

    }

    private List<User> createUsers() {
        return Arrays.asList(
                new User("Edwin", "Hernandez", "27"),
                new User("Jose", "Cruz", "27"),
                new User("Omar", "Ham", "27")
        );
    }
}
