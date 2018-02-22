package com.nca.testandroid.hw5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;


import com.nca.testandroid.R;
import com.nca.testandroid.classwork1.Classwork1Activity;

public class Homework5Activity extends AppCompatActivity {

    private ImageView imageView;
    ToggleButton toggle;
    WiFiService mService;
    boolean mBound = false;


    private BroadcastReceiver innerReceiver = new BroadcastReceiver(){

        @Override    public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected() && netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.e("MyBroadcastReceiver", " WI-FI ON");
                imageView.setImageResource(R.drawable.ic_wifi_white_24px);
            } else {
                Log.e("MyBroadcastReceiver", " WI-FI OFF");
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

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(innerReceiver, intentFilter);

        Intent intent = new Intent(this, WiFiService.class);
        // привязка компонента unbind - отвязка
        //        bindService(intent, MyService.class)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);


        //Настраиваем слушателя изменения состояния переключателя:
//        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                //Если Wi-FI включен - Toast сообщение об этом:
//                if (isChecked) {
//                    mService.setWiFiStatus(true);
//                }
//                //Если Wi-FI выключен - Toast сообщение об этом:
//                else {
//                    mService.setWiFiStatus(false);
//                }
//            }
//
//        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(innerReceiver);

        unbindService(mConnection);
    }


    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            WiFiService.LocalBinder binder = (WiFiService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };
}
