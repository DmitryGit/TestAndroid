package com.nca.testandroid.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// сюда приходят события на которые мы подписались
public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        intent.getAction();

//        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
//        if(isAirplaneModeOn){
//
//            Log.e("AAAAAAAAAAAA", "MESSAGE FROM ACTIVITY ON");
//        } else {
//            Log.e("AAAAAAAAAAAA", "MESSAGE FROM ACTIVITY OFF");
//        }

    }
}
