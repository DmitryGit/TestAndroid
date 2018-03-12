package com.nca.presentation.screen.user;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.nca.domain.entity.UserEntity;
import com.nca.presentation.base.BaseViewModel;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends BaseViewModel {

    public ObservableField<String> username = new ObservableField<>("");
    public ObservableField<String> profileUrl = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onResume() {

        progressVisible.set(true);
        Observable.create(new ObservableOnSubscribe<UserEntity>() {
            @Override
            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
                Thread.sleep(5000);
                UserEntity userEntity = new UserEntity("super user", 20, "");

                emitter.onNext(userEntity);
                emitter.onComplete();
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<UserEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("AAA", "onSubscribe");
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(UserEntity userEntity) {
                Log.e("AAA", "onNext");
                username.set(userEntity.getUsername());
                profileUrl.set(userEntity.getProfileUrl());
                age.set(userEntity.getAge());
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
        })
        ;
    }

    @Override
    public void onPause() {
        super.onPause();
        compositeDisposable.dispose();
    }
}
