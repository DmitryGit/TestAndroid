package com.nca.testandroid.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nca.testandroid.R;

import static android.Manifest.permission.ACCESS_NETWORK_STATE;

// библиотека butterknife для досткпа к id и прочее
public class Classwork5Activity extends AppCompatActivity {

    private static final String TAG = Classwork5Activity.class.getSimpleName();

    private static final String ACTION_MY_MESSAGE = "com.nca.testandroid.classwork5.ACTION_MY_MESSAGE";

    private Button button1;

    LocalBroadcastManager broadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork1);

        button1 = findViewById(R.id.button1);

        broadcastManager = LocalBroadcastManager.getInstance(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //                Intent intent = new Intent(ACTION_MY_MESSAGE);
                Intent intent = new Intent();
                intent.setAction(ACTION_MY_MESSAGE);
            // этот общий броадкаст рисивер
//                sendBroadcast(intent);
            // этот локальный  броадкаст рисивер
                broadcastManager.sendBroadcast(intent);


            }
        });
        Log.e(TAG, "onCreate()");
    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("AAAAAAAAAAAA", "MESSAGE");

        }
    };

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MY_MESSAGE);
//        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        // можно добавить локальный broadcastManager
        registerReceiver(myReceiver, intentFilter);

        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        // привязка компонента unbind - отвязка
        //        bindService(intent, MyService.class)

        Intent intent2 = new Intent(this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_LINK, "http://film1");
        startService(intent2);

        Intent intent3 = new Intent(this, MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_LINK, "http://film2");
        startService(intent3);

        Intent intent4 = new Intent(this, MyIntentService.class);
        intent4.putExtra(MyIntentService.KEY_LINK, "http://film3");
        startService(intent4);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);

        stopService(new Intent(this, MyService.class));
    }
}
