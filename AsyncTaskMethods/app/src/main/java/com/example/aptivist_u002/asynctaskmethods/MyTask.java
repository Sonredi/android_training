package com.example.aptivist_u002.asynctaskmethods;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

/**
 * Created by Aptivist-U002 on 10/19/2017.
 */

public class MyTask extends AsyncTask<Void, Integer, Void>{

    private static final String TAG = "MyTaskTAG_";
    private WeakReference<ProgressBar> progressBar;

    public MyTask(ProgressBar progressBar) {
        this.progressBar=  new WeakReference<ProgressBar>(progressBar);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i < 300; i++) {
            publishProgress(i);
            Log.d(TAG, "doInBackground: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        ProgressBar progressBar = this.progressBar.get();
        if (progressBar !=null) {
            progressBar.setProgress(values[0]);
        }

    }
}
