package com.nca.presentation.base;

import android.support.annotation.Nullable;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<View extends BaseView, R extends Router> {

    public BasePresenter() {
        super();
        createInject();
    }

    public abstract void createInject();

    @Nullable
    protected View view;

    @Nullable
    protected R router;


    public void attach(View view, R router) {
        this.view = view;
        this.router = router;
    }

    public void detach() {
        view = null;
        router = null;
    }

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();


    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    public void onDestroy() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
