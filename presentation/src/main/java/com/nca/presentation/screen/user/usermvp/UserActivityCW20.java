package com.nca.presentation.screen.user.usermvp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nca.data.sharedprefs.AppSharedPrefs;
import com.nca.presentation.base.BaseMvvActivity;
import com.nca.presentation.screen.user.UserViewModel;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityUserBinding;

import javax.inject.Inject;

public class UserActivityCW20 extends BaseMvvActivity<ActivityUserBinding, UserViewModel> {


    @Inject
    AppSharedPrefs appSharedPrefs;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModel.class);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean flag = appSharedPrefs.getTipsShow();
        if (!flag) {
            appSharedPrefs.saveTipsShow();
        }
    }
}

// gradlew assemble - собирает APK

// fabric.io для обновления приложений и получения ошибок