package com.nca.presentation.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

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
