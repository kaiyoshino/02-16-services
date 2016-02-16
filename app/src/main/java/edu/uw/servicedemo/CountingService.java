package edu.uw.servicedemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.util.Log;

/**
 * Created by kai on 2/16/16.
 */
public class CountingService extends IntentService {

    private static final String TAG = "**IS**";

    public CountingService() {
        super("CountingService");
    }

    @Override
    public void onCreate() {
        Log.v(TAG, "Service Created");
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "Received Intent");

//        return Service.START_NOT_STICKY;

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.v(TAG, "Handling Intent");

        for (int i=0; i<10; i++) {
            Log.v(TAG, "" + i);

//            if (i==3) {
//                stopSelf();
//            }

            try {
                Thread.sleep(5000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public void onDestroy() {
        Log.v(TAG, "Service finished");
        super.onDestroy();
    }

}
