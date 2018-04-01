package com.nca.presentation.screen.hw11;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.nca.app.App;
import com.nca.data.entity.User;
import com.nca.domain.entity.UserEntity;
import com.nca.domain.entity.UserEntityHW11;
import com.nca.domain.interactors.GetUserByIdUseCase;
import com.nca.presentation.base.BaseViewModel;
import com.nca.presentation.screen.user.UserViewModel;
import com.nca.testandroid.utils.MyAppGlideModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class UserViewModelHW11 extends BaseViewModel {

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;
//    GetUserByIdUseCase getUserByIdUseCase = new GetUserByIdUseCase(new UIThread(), new UserRepositoryImpl());

    private static UserEntityAdapter userEntityAdapter;
    public List<UserEntityHW11> userEntities1 = new ArrayList<UserEntityHW11>();

    public ObservableField<String> username = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableField<String> profileUrl = new ObservableField<>("");
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

//    @BindingAdapter({"bind:imageUrl"})
//    public static void loadImage(ImageView view, String url) {
//        MyAppGlideModule.showImage(view.getContext(), url, view);
//    }

    @BindingAdapter("bind:items")
    public static void bindList(RecyclerView view, List<UserEntityHW11> userEntities1) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(userEntityAdapter);
    }

    public void click() {
//                Intent activity = new Intent(UserActivityRecyclerView.this, UserViewModelHW11.class);
////                activity.putExtra("myObject", new Gson().toJson(userEntity));
//                startActivity(activity);


    }

    public UserViewModelHW11() {

        userEntityAdapter = new UserEntityAdapter();
        userEntityAdapter.setListener(new UserEntityAdapter.OnUserClickListener() {
            @Override
            public void onClick(UserEntityHW11 userEntity, int position) {
//                click();
                UserViewModelHW11.super.setUserEntityHW11(userEntityHW11);

                Log.e("q", userEntity.getProfileUrl());

            }
        });

        getUserByIdUseCase.get()
            .subscribe(new Observer<List<UserEntityHW11>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("AAA", "onSubscribe");
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<UserEntityHW11> userEntities) {
                Log.e("AAA", "onNext");
                userEntities1.addAll(userEntities);
                userEntityAdapter.setUserEntityList(userEntities1);

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
