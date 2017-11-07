package com.example.aptivist_u002.a10222017_servicessample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainACtivityTAG_";
    private boolean isBounded = false;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected: ");
            isBounded = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected: ");
            isBounded = false;
        }
    };

    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.a_main_text1);

    }

    public void startMAgic(View view) {
        Intent intent = new Intent(this, StartedService.class);
        intent.putExtra("name", editText1.getText().toString());

        startService(intent);

    }

    public void stopMagic(View view) {
        Intent intent = new Intent(this, StartedService.class);
        stopService(intent);
    }

    public void intentServiceMagic(View view) {
        Intent intent = new Intent(this, IntentService.class);
        startService(intent);
    }

    public void bindService(View view) {
        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

    }

    public void unbindService(View view) {
        if (isBounded){
        unbindService(serviceConnection);}
    }
}
