package com.nca.testandroid.classwork5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service", "onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Service", "onDestroy()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Service", "onCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e("Service", "onDestroy()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Service", "onBind()");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Service", "onUnbind()");
        return super.onUnbind(intent);
    }
}
