package com.example.aptivist_u002.a10242017databasesample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    private EditText editText1;
    private EditText editText2;
    private ListView lvItems;
    private Cursor cursor;
    private TodoCursorAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.main_text1);
        editText2 = (EditText) findViewById(R.id.main_text2);
        lvItems = (ListView) findViewById(R.id.lvItems);
    }

    public void saveData(View view) {
        UsersOpenHelper usersOpenHelper = new UsersOpenHelper(this);
        SQLiteDatabase sqLiteDatabase = usersOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersOpenHelper.COLUMN_NAME, editText1.getText().toString());
        contentValues.put(UsersOpenHelper.COLUMN_AGE, Integer.parseInt(editText2.getText().toString()));

        sqLiteDatabase.insert(UsersOpenHelper.TABLE_NAME, null, contentValues);
        loadData(view);
//        todoAdapter.changeCursor(cursor);
    }

    public void loadData(View view) {
        UsersOpenHelper usersOpenHelper = new UsersOpenHelper(this);
        SQLiteDatabase sqLiteDatabase = usersOpenHelper.getReadableDatabase();

        cursor = sqLiteDatabase.query(UsersOpenHelper.TABLE_NAME, null, null, null, null, null, null);

        todoAdapter = new TodoCursorAdapter(this, cursor);
        // Attach cursor adapter to the ListView
        lvItems.setAdapter(todoAdapter);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                parseInfo(cursor);
            } while (cursor.moveToNext());
        }

        //cursor.close();
    }

    private void parseInfo(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(UsersOpenHelper.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(UsersOpenHelper.COLUMN_NAME));
        int age = cursor.getInt(cursor.getColumnIndex(UsersOpenHelper.COLUMN_AGE));

        Log.d(TAG, "parseInfo: " + id + " " + name + " " + age);

    }


}
