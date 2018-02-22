package com.nca.testandroid.hw5;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

public class WiFiService  extends Service {

    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        WiFiService getService() {
            // Return this instance of LocalService so clients can call public methods
            return WiFiService.this;
        }
    }

//    @Nullable
    @Override
    public IBinder onBind(Intent intent) throws UnsupportedOperationException {
        Log.e("Service", "onBind()");
        return mBinder;

    }

    /** method for clients */
    public void setWiFiStatus(boolean status) {
        Log.e("Service", "setWiFiStatus("+status+")");
//        return mGenerator.nextInt(100);
        //Описываем сам метод включения Wi-Fi:
        WifiManager wifiManager = (WifiManager) this.getSystemService(android.content.Context.WIFI_SERVICE);

        //Статус true соответствует включенному состоянию Wi-Fi, мы включаем
        //его с помощью команды wifiManager.setWifiEnabled(true):
        if (wifiManager != null) {

            if (status && !wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            //А статус false соответствует выключенному состоянию Wi-Fi мы выключаем
            // его с помощью команды wifiManager.setWifiEnabled(false):
            else if (!status && wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(false);
            }
        }

    }

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


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Service", "onUnbind()");
        return super.onUnbind(intent);
    }

}
