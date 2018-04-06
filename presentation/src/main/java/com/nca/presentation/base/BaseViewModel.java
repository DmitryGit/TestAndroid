package com.nca.presentation.base;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.nca.domain.entity.UserEntityHW11;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<R extends Router> extends ViewModel {

    public BaseViewModel() {
        super();
        createInject();
    }

    public abstract void createInject();

    @Nullable
    protected R router;


    public void attachRouter(R router) {
        this.router = router;
    }

    public void detachRouter() {
        router = null;
    }


    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected static UserEntityHW11 userEntityHW11;

    public UserEntityHW11 getUserEntityHW11() {
        return userEntityHW11;
    }

    public void setUserEntityHW11(UserEntityHW11 userEntityHW11) {
        this.userEntityHW11 = userEntityHW11;
    }


    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
