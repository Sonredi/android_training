package com.example.aptivist_u002.a10222017_broadcastreceiversample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Aptivist-U002 on 10/22/2017.
 */

public class AirplaneReceiver extends BroadcastReceiver {
    private static final String TAG = "AirplaneReceiverTAG_";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        if (intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
            Toast.makeText(context, "Airplane mode", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "data change", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(context, DetailActivity.class);
            boolean bo = Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
            intent1.putExtra("AIR", String.valueOf(bo));
            context.startActivity(intent1);

        }
    }
}
