package com.nca.presentation.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    public BaseViewModel() {
        super();
        createInject();
    }

    public abstract void createInject();

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

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
