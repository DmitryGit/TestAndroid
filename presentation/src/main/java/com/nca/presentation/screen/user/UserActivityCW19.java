package com.nca.presentation.screen.user;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.nca.notification.NewMessageNotification;
import com.nca.presentation.utils.ImageChooser;
import com.nca.testandroid.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import io.fabric.sdk.android.Fabric;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

//adb shell monkey -p com.nca.testandroid -v 5000

//public class UserActivityCW19 extends BaseMvvActivity<ActivityUserCw19Binding, UserViewModelCW14, UserRouter> {
public class UserActivityCW19 extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cw19);
//        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        binding.recyclerView.setHasFixedSize(true);
//        binding.recyclerView.setAdapter(viewModel.userAdapter);

// если нужно занинуть в крешлитикс эксепшен
//        Crashlytics.logException(e);

        Fabric.with(this, new Crashlytics());
//        Toolbar toolbar = binding.toolBar;
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_android_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageChooser.startCamera(UserActivityCW19.this);
//                ImageChooser.startGalery(UserActivityCW19.this);

            }
        });
        NewMessageNotification.notify(this, "sdddddddddddd", 5 );

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == Activity.RESULT_OK) {
            File file = ImageChooser.getImageFromResult(this, requestCode, resultCode, data);
            if(file != null) {
                Log.e("AA", "file = " + file.getAbsolutePath());
            } else {
                    Log.e("AA", "file is null");
                }
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optional_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.actionSearch): {
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        int a = 5/0;
    }



    @Override
    protected void onResume() {
        super.onResume();

        RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean granted) {
                        if(granted) {
                            getLocation();
                        } else {
                            // нет разрешения, выводим диалог о том что не можем открыть галерею
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    Log.e("lat: ", String.valueOf(location.getLatitude()));
                    Log.e("lon: ", String.valueOf(location.getLongitude()));
                } else {
                    Log.e("Error", "нет локации");
                }

            }
        });

    }
}

// android google github sample architecture