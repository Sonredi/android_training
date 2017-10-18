package com.example.aptivist_u002.okhttpgson;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String API_URL = "http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8";
    private ListView lvStudent;
    private ArrayList<Student> listStudent;
    private OkHttpClient okHttpClient;
    private ArrayAdapter<Student> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okHttpClient = new OkHttpClient();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        lvStudent = (ListView) findViewById(R.id.a_main_lvStudents);
        listStudent = new ArrayList<>();
        adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, listStudent);
        lvStudent.setAdapter(adapter);

        final Context context = getBaseContext();
        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                 Intent intent = new Intent(context, Detail.class);
                                                 intent.putExtra("Object", listStudent.get(position));
                                                 startActivity(intent);
                                             }
                                         }
        );
    }

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();

    }

    public void getJSON(View view) {

        Gson gson = new Gson();
        try {
            String response = run(API_URL);
            Student[] students = gson.fromJson(response, Student[].class);

        listStudent.clear();
        listStudent.addAll(Arrays.asList(students));
        adapter.notifyDataSetChanged();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
