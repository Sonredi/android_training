package com.example.aptivist_u002.snackbarassignment;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private List<Object> users;
    CoordinatorLayout coordinatorLayout;

    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.a_main_recycler);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator);
        users = createUsers();




        customAdapter = new CustomAdapter(users, this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);

    }

    private List<Object> createUsers() {
        ArrayList<Object> items = new ArrayList<>();
        items.add(new User("Dany Targaryen", "Valyria"));
        items.add(new User("Rob Stark", "Winterfell"));
        items.add("image");
        items.add(new User("Jon Snow", "Castle Black"));
        items.add("image");
        items.add(new User("Tyrion Lanister", "King's Landing"));
        return items;
    }

    @Override
    public void onItemClick(User item) {
        //Toast.makeText(this, "Clickkkkk", Toast.LENGTH_SHORT).show();
        Snackbar mySnackbar = Snackbar.make(coordinatorLayout,"name: " + item.getFirstName() + " " +item.getLastName(), Snackbar.LENGTH_SHORT);
        //mySnackbar.setAction(R.string.undo_string, new MyUndoListener());
        mySnackbar.show();
    }
}
