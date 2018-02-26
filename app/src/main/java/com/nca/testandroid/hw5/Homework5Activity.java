package com.nca.testandroid.hw5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import android.widget.ImageView;
import android.widget.ToggleButton;
import com.nca.testandroid.R;

public class Homework5Activity extends AppCompatActivity {

    private ImageView imageView;
    private ToggleButton toggle;
    private WiFiService mService;
    private boolean mBound = false;

    private BroadcastReceiver innerReceiver = new BroadcastReceiver(){

        @Override    public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected() && netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.e("BroadcastReceiver", " WI-FI ON");
                toggle.getTextOn();
                toggle.setChecked(true);
                imageView.setImageResource(R.drawable.ic_wifi_white_24px);
            } else {
                Log.e("BroadcastReceiver", " WI-FI OFF");
                toggle.getTextOff();
                toggle.setChecked(false);
                imageView.setImageResource(R.drawable.ic_wifi_black_24px);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        imageView = findViewById(R.id.wifi);
        toggle = findViewById(R.id.wifi_switcher);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound) {
                    if (toggle.isChecked()) {
                        mService.setWiFiStatus(true);
                    } else {
                        mService.setWiFiStatus(false);
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(innerReceiver, intentFilter);
        Intent intent = new Intent(this, WiFiService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(innerReceiver);
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("ServiceConnection", " onServiceConnected");
            WiFiService.LocalBinder binder = (WiFiService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("ServiceConnection", " onServiceDisconnected");
            mBound = false;
        }
    };
}
