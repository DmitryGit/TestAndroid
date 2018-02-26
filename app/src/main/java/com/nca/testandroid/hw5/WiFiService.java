package com.nca.testandroid.hw5;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class WiFiService extends Service {

    private final IBinder mBinder = new LocalBinder();

    class LocalBinder extends Binder {
        WiFiService getService() {
            return WiFiService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) throws UnsupportedOperationException {
        Log.e("WiFiService", "onBind()");
        return mBinder;

    }

    public void setWiFiStatus(boolean status) {
        Log.e("WiFiService", "setWiFiStatus("+status+")");
        WifiManager wifiManager = (WifiManager) this.getSystemService(android.content.Context.WIFI_SERVICE);

        if (wifiManager != null) {
            if (status && !wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            else if (!status && wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(false);
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("WiFiService", "onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("WiFiService", "onDestroy()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("WiFiService", "onCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e("WiFiService", "onDestroy()");
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("WiFiService", "onUnbind()");
        return super.onUnbind(intent);
    }

}
