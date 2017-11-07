package com.example.aptivist_u002.a10312017locationmanagersample;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Aptivist-U002 on 10/31/2017.
 */

public class LocationHelper implements LocationListener {
    private static final String TAG = "LocationHelperTAG_";
    private LocationManager locationManager;

    public LocationHelper(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    public void startUpdate() {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
    }

    public void stopUpdates() {
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged: " + location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d(TAG, "onStatusChanged: " + s + " " + i+ " " + bundle);
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d(TAG, "onProviderEnabled: " + s);
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d(TAG, "onProviderDisabled: " + s);
    }

    public void getActualLocation() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_HIGH);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String bestProvider = locationManager.getBestProvider(criteria, false);
        Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);

        double latitude = lastKnownLocation.getLatitude();
        double longitude = lastKnownLocation.getLongitude();
        String provider = lastKnownLocation.getProvider();
        Log.d(TAG, "getActualLocation: latitude: " + latitude + " longitude :" + longitude + " provider :" + provider);

    }
}
