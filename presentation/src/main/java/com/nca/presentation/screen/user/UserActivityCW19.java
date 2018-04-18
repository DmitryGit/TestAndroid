package com.nca.presentation.screen.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.nca.notification.NewMessageNotification;
import com.nca.presentation.utils.ImageChooser;
import com.nca.testandroid.R;

import java.io.File;

import io.fabric.sdk.android.Fabric;

//public class UserActivityCW19 extends BaseMvvActivity<ActivityUserCw19Binding, UserViewModelCW14, UserRouter> {
public class UserActivityCW19 extends AppCompatActivity {

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

            }
        });
        NewMessageNotification.notify(this, "sdddddddddddd", 5 );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        File file = ImageChooser.getImageFromResult(this, requestCode, resultCode, data)
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
}

// android google github sample architecture