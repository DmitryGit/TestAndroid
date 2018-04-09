package com.nca.presentation.screen.user.usermvp;

import android.util.Log;

import com.nca.app.App;
import com.nca.domain.entity.UserEntity;
import com.nca.domain.interactors.GetUserByIdUseCase;
import com.nca.presentation.base.BasePresenter;
import com.nca.presentation.screen.user.list.UserAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class SignUserPresenter extends UserPresenter {


    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;

    public UserAdapter userAdapter = new UserAdapter();

    public SignUserPresenter() {

        view.showProgress();

        getUserByIdUseCase.getRoom().subscribe(new Observer<List<UserEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("AAA", "onSubscribe");
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<UserEntity> userEntity) {
                Log.e("AAA", "onNext");

                //TODO impliment
                view.showUser(userEntity.get(0));

                //                firstName.set(userEntity.get(0).getFirstName());
//                lastName.set(userEntity.get(0).getLastName());
//                fatherName.set(userEntity.get(0).getFatherName());
//                age.set(userEntity.get(0).getAge());
////                isMan.set(userEntity.get(3).isMan());
////                imageUrl.set(userEntity.getImageUrl());
//                imageUrl.set(userEntity.get(0).getImageUrl());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("AAA", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("AAA", "onComplete");
                view.dismissProgress();
            }

        });

    }

// click тут

    @Override
    public UserAdapter getUserAdapter() {
        return null;
    }

    @Override
    public void onUserClick() {

    }
}
