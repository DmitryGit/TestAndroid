package com.nca.presentation.screen.hw11;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.nca.app.App;
import com.nca.data.entity.User;
import com.nca.domain.entity.UserEntityHW11;
import com.nca.domain.interactors.GetUserByIdUseCase;
import com.nca.presentation.base.BaseViewModel;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityHw11UserEditBinding;
import com.nca.testandroid.hw9.Homework9Activity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class UserViewModelHW11e extends BaseViewModel {

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;
//    GetUserByIdUseCase getUserByIdUseCase = new GetUserByIdUseCase(new UIThread(), new UserRepositoryImpl());

//    ActivityHw11UserEditBinding binding = DataBindingUtil.setContentView(UserViewModelHW11e.this, R.layout.activity_homework9);

    public ObservableField<String> username = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableField<String> profileUrl = new ObservableField<>("");
    public ObservableField<String> id = new ObservableField<>();
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    public CompositeDisposable compositeDisposable = new CompositeDisposable();


//    public void onClick(View view) {
//        UserEntityHW11 user = new UserEntityHW11();
//        String bId = binding.userId.getText().toString();
//        String bAge = binding.age.getText().toString();
//        String bUsername = binding.username.getText().toString();
//        String bProfileUrl = binding.profileUrl.getText().toString();
//        if (!TextUtils.isEmpty(bAge)) {
//            user.setAge(Integer.parseInt(bAge));
//        }
//        if (!TextUtils.isEmpty(bUsername)) {
//            user.setUsername(bUsername);
//        }
//        if (!TextUtils.isEmpty(bProfileUrl)) {
//            user.setProfileUrl(bProfileUrl);
//        }
//
//        getUserByIdUseCase.save(bId, user);
////                Intent activity = new Intent(UserViewModelHW11.this, UserActivityEdit.class);
////                activity.putExtra("myObject", new Gson().toJson(userEntity));
////                startActivity(activity);
////        Log.e("q", userEntity.getProfileUrl());
//
//    }

    public UserViewModelHW11e() {

//        String id = "";
        getUserByIdUseCase.get("33F81481-25E6-475A-FF90-EE1C1D6EAE00") // "41B3402-0AD7-3175-FFBF-A1305ED6CC00"
//        UserEntityHW11 userEntityHW11 = new UserEntityHW11("EEEE", 12, "http//:fff", "33F81481-25E6-475A-FF90-EE1C1D6EAE00");
//        getUserByIdUseCase.get(userEntityHW11.getId())
//        getUserByIdUseCase.get(UserViewModelHW11e.super.getUserEntityHW11().getId())
            .subscribe(new Observer<UserEntityHW11>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("AAA", "onSubscribe");
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(UserEntityHW11 userEntity) {
                Log.e("AAA", "onNext");
//                userEntities1.addAll(userEntities);
//                binding.setUserEntity(userEntity);
                username.set(userEntity.getUsername());
                profileUrl.set(userEntity.getProfileUrl());
                id.set(userEntity.getId());
                age.set(userEntity.getAge());
//                userEntityAdapter.setUserEntityList(userEntities1);

            }

            @Override
            public void onError(Throwable e) {
                Log.e("AAA", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("AAA", "onComplete");
                progressVisible.set(false);
            }
        });
    }
}
