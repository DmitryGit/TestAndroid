package com.nca.presentation.screen.user;

import com.nca.presentation.base.BaseMvvActivity;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityUserBinding;

public class UserActivity extends BaseMvvActivity<ActivityUserBinding, UserViewModel> {

    private static final String TAG = UserActivity.class.getSimpleName();

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return new UserViewModel();
    }
}
