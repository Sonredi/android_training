package com.example.aptivist_u002.viewholderpatternassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<User> users;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.a_main_list);
        users = createUsers();

        customAdapter = new CustomAdapter(this, users);
        listView.setAdapter(customAdapter);


    }

    private List<User> createUsers() {
        return Arrays.asList(
                new User("Edwin", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin1", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias1", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin2", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias2", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin3", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias3", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin4", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias4", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin5", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias5", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin6", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias6", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin7", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias7", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin8", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias8", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin9", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias9", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin11", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias11", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Edwin12", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias12", "Lagunes", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Omar", "Ham", "https://cdn1.iconfinder.com/data/icons/unique-round-blue/93/user-512.png")
        );
    }
}
