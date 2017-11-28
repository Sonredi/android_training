package com.example.aptivist_u002.a11082017contentprovidersample;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "TAG_";

    private RecyclerView recyclerView;
    private MinimalAdapter minimalAdapter;
    private List<String[]> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView = findViewById(R.id.a_detail_recycler);
        contacts = new ArrayList<>();
        minimalAdapter = new MinimalAdapter(contacts);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(minimalAdapter);

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection    = new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};

        Cursor people = getContentResolver().query(uri, projection, null, null, null);

        int indexName = people.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        int indexNumber = people.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

        if(people.moveToFirst()) {
            do {
                String[] aux = new String[2];
                aux[0] = people.getString(indexName);
                aux[1] = people.getString(indexNumber);
                String name   = people.getString(indexName);
                String number = people.getString(indexNumber);
                contacts.add(aux);
                // Do work...
                Log.d(TAG, "onCreate: " + name + number);
            } while (people.moveToNext());
        }
    }
}
