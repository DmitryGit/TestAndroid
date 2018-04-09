package com.nca.presentation.base;


import org.w3c.dom.Entity;

public interface BaseView {

    void showProgress();
    void dismissProgress();
//    void showError(Throwable throwable);
    void showError(Exception e);
}
