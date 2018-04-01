package com.nca.presentation.screen.hw11;

import android.arch.lifecycle.ViewModelProviders;

import com.nca.presentation.base.BaseMvvActivity;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityUserBinding;

public class UserActivityRecyclerView extends BaseMvvActivity<ActivityUserBinding, UserViewModelHW11> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_hw11_recycler_view;
    }

    @Override
    public UserViewModelHW11 provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModelHW11.class);
    }

}

// android google github sample architecture