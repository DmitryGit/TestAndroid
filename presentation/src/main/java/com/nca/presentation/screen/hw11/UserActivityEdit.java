package com.nca.presentation.screen.hw11;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.nca.domain.entity.UserEntityHW11;
import com.nca.presentation.base.BaseMvvActivity;
import com.nca.presentation.screen.user.UserViewModel;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityHomework9Binding;
import com.nca.testandroid.databinding.ActivityHw11UserEditBinding;
import com.nca.testandroid.databinding.ActivityUserBinding;
import com.nca.testandroid.hw9.User;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class UserActivityEdit extends BaseMvvActivity<ActivityHw11UserEditBinding, UserViewModelHW11e> {

    private Disposable disposable;
    ActivityHw11UserEditBinding binding;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_hw11_user_edit;
    }

    @Override
    public UserViewModelHW11e provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModelHW11e.class);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = super.binding;

        binding.setViewModel(provideViewModel());


        binding.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntityHW11 user = new UserEntityHW11();
                String bId = binding.userId.getText().toString();
                String bAge = binding.age.getText().toString();
                String bUsername = binding.username.getText().toString();
                String bProfileUrl = binding.profileUrl.getText().toString();
                if (!TextUtils.isEmpty(bAge)) {
                    user.setAge(Integer.parseInt(bAge));
                }
                if (!TextUtils.isEmpty(bUsername)) {
                    user.setUsername(bUsername);
                }
                if (!TextUtils.isEmpty(bProfileUrl)) {
                    user.setProfileUrl(bProfileUrl);
                }
                if (!TextUtils.isEmpty(bId)) {
                    user.setId(bId);
                }

                Completable completable = provideViewModel().getUserByIdUseCase.save(user.getId(), user);

            }
        });


//    getUserByIdUseCase.save(bId, user);
//                Intent activity = new Intent(UserViewModelHW11.this, UserActivityEdit.class);
//                activity.putExtra("myObject", new Gson().toJson(userEntity));
//                startActivity(activity);
//        Log.e("q", userEntity.getProfileUrl());

}




}

// android google github sample architecture