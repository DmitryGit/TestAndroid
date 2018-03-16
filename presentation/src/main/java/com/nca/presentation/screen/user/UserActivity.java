package com.nca.presentation.screen.user;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;

import com.nca.presentation.base.BaseMvvActivity;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityUserBinding;

public class UserActivity extends BaseMvvActivity<ActivityUserBinding, UserViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModel.class);
    }

}

// android google github sample architecture