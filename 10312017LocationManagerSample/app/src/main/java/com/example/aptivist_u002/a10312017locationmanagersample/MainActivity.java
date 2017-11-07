package com.example.aptivist_u002.a10312017locationmanagersample;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private Button buttonStart;
    private Button buttonStop;
    private Button buttonCurrent;
    private Button buttonFused;

    private LocationHelper locationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.a_main_btn_start);
        buttonStop = findViewById(R.id.a_main_btn_stop);
        buttonCurrent = findViewById(R.id.a_main_btn_current);
        buttonFused = findViewById(R.id.a_main_btn_fused);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationHelper = new LocationHelper(locationManager);


        buttonStart.setOnClickListener(view -> locationHelper.startUpdate());

        buttonStop.setOnClickListener(view -> locationHelper.stopUpdates());
        buttonCurrent.setOnClickListener(view -> locationHelper.getActualLocation());

        buttonFused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FusedLocationProviderClient fusedLocationProviderClient = getFusedLocationProviderClient(MainActivity.this);
                Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
                lastLocation.addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Log.d(TAG, "onSuccess: " + location);
                    }
                });
            }
        });
    }
}
