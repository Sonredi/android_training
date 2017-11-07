package com.example.aptivist_u002.a10302017jsonparsesample;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String MY_JSON = "[\n" +
            "    {\"name\" : \"Juan\", \"age\": 20, \"grade\": 8.1},\n" +
            "    {\"name\" : \"Miguel\", \"age\": 23, \"grade\": 8.3},\n" +
            "    {\"name\" : \"Roberto\", \"age\": 39, \"grade\": 9.3},\n" +
            "    {\"name\" : \"Luis\", \"age\": 19, \"grade\": 6.9},\n" +
            "    {\"name\" : \"Gaudencio\", \"age\": 25, \"grade\": 4.3}\n" +
            "]";
    private static final String TAG = "MainActivityTAG_";

    private Button button;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.a_main_btn);
        button.setOnClickListener(this);

        handler = new MyHandler();

//        try {
//            List<Student> students = parseJson(MY_JSON);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

    private static List<Student> parseJson(String myJson) throws JSONException {
        JSONArray jsonArray = new JSONArray(myJson);
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());

            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            double grade = jsonObject.getDouble("grade");

            Log.d(TAG, "parseJson: " + name + " " + age + " " + grade);
            studentList.add(new Student(name, age, grade));
        }
        return studentList;
    }

    @Override
    public void onClick(View view) {
        new DownloadThread(handler).start();
    }

    private static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG, "handleMessage: " + msg);
            Bundle bundle = msg.getData();
            String resultBundle = bundle.getString("MY_KEY");

            try {
                List<Student> students = parseJson(resultBundle);
                Log.d(TAG, "onClick: " + students.size());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
