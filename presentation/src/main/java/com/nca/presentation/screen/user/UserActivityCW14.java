package com.nca.presentation.screen.user;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.nca.presentation.base.BaseMvvActivity;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityUserBinding;
import com.nca.testandroid.databinding.ActivityUserCw14Binding;

public class UserActivityCW14 extends BaseMvvActivity<ActivityUserCw14Binding, UserViewModelCW14> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModelCW14 provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModelCW14.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(viewModel.userAdapter);
    }
}

// android google github sample architecture