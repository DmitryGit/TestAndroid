package com.nca.data.sharedprefs;

import android.content.Context;

import javax.inject.Inject;

public class AppSharedPrefs {

    private Context context;

    @Inject
    public AppSharedPrefs(Context context) {
        this.context = context;
    }

    public void saveTipsShow() {

    }

    public boolean getTipsShow() {
        return true;
    }
}
