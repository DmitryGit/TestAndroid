package com.nca.testandroid.hw5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;


import com.nca.testandroid.R;
import com.nca.testandroid.classwork1.Classwork1Activity;

public class Homework5Activity extends AppCompatActivity {

    private ImageView imageView;

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(innerReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(innerReceiver);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.e(TAG, "onDestroy()");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e(TAG, "onResume()");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.e(TAG, "onRause()");
//    }


}
